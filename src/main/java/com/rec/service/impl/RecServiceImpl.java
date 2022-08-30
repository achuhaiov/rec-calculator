package com.rec.service.impl;

import com.rec.dto.RecInfo;
import com.rec.entity.CaseNotLifePremium;
import com.rec.entity.Cedant;
import com.rec.entity.Country;
import com.rec.entity.SlipsPremium;
import com.rec.repository.*;
import com.rec.service.RecService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Component
public class RecServiceImpl implements RecService {

    private static final BigDecimal METHOD_PERCENTAGE = BigDecimal.valueOf(0.36);

    private final CedantRepository cedantRepository;
    private final BranchRepository branchRepository;
    private final SlipsPremiumRepository slipsPremiumRepository;
    private final CaseNotLifePremiumRepository caseNotLifePremiumRepository;
    private final CountryRepository countryRepository;

    public RecServiceImpl(CedantRepository cedantRepository,
                          BranchRepository branchRepository,
                          SlipsPremiumRepository slipsPremiumRepository,
                          CaseNotLifePremiumRepository caseNotLifePremiumRepository,
                          CountryRepository countryRepository) {
        this.cedantRepository = cedantRepository;
        this.branchRepository = branchRepository;
        this.slipsPremiumRepository = slipsPremiumRepository;
        this.caseNotLifePremiumRepository = caseNotLifePremiumRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<RecInfo> getRECs(String regionName, String countryName, String groupName, String branchType, String confirmationStatus) {
        List<ObjectId> cedantsIds = cedantRepository.findIds(regionName, countryName, groupName);
        List<ObjectId> branchIds = branchRepository.findIds(branchType);
        List<ObjectId> slipsPremiumIds = slipsPremiumRepository.findIds(confirmationStatus);
        List<CaseNotLifePremium> caseNotLifePremiums = caseNotLifePremiumRepository.findByCedantsAndBranchesAndSlips(cedantsIds, branchIds, slipsPremiumIds);

        List<RecInfo> result = new ArrayList<>();

        for (CaseNotLifePremium caseNotLifePremium : caseNotLifePremiums) {
            RecInfo recInfo = new RecInfo();

            SlipsPremium slipsPremium = slipsPremiumRepository.findById(caseNotLifePremium.getSlipesPrimeId());
            recInfo.setReferences(slipsPremium.getReference());
            recInfo.setValidationStatus(slipsPremium.getValidationStatus());
            recInfo.setConfirmationStatus(slipsPremium.getConfirmationStatus());
            recInfo.setPublicationDate(slipsPremium.getPublishedDate());

            Cedant cedant = cedantRepository.findById(caseNotLifePremium.getCedantsId());
            recInfo.setCedants(cedant.getName());
            recInfo.setBranch(caseNotLifePremium.getBranch());

            Country country = countryRepository.findById(cedant.getCountriesId());
            recInfo.setCountry(country.getName());

            recInfo.setCalculatedREC(caseNotLifePremium.getSumPremiumHt().multiply(METHOD_PERCENTAGE));

            result.add(recInfo);
        }

        return result;
    }

}
