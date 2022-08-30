package com.rec.service;

import com.rec.dto.RecInfo;

import java.util.List;

public interface RecService {

    List<RecInfo> getRECs(String regionName, String countryName, String groupName, String branchType, String confirmationStatus);
}
