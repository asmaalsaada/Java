package com.codingdojo.driver.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.codingdojo.driver.models.License;
import com.codingdojo.driver.repository.LicenseRepository;

@Service
public class LicenseService  {
final private LicenseRepository licenceRepository;

public LicenseService(LicenseRepository licenceRepository) {
	super();
	this.licenceRepository = licenceRepository;
}

public List<License> allLicense(){
	return licenceRepository.findAll();
}
public License create(License l) {
	return licenceRepository.save(l);
}
public static int licenseNumber;

public static int getLicenseNumber() {
    return licenseNumber;
}

public static void setLicenseNumber(int licenseNumber) {
    LicenseService.licenseNumber = licenseNumber;
}

public String stringLicenseNumber(int num) {
    String format = String.format("%06d", num);
    return format;
}

public String generateLicenseNumber() {
    if(licenceRepository.findAll().isEmpty()) {
        licenseNumber +=1;
        return stringLicenseNumber(licenseNumber);
    }
    else {
        List<License> top = licenceRepository.findTopByOrderByNumberDesc() ;
        licenseNumber = 1+(Integer.parseInt(top.get(0).getNumber()));
        return stringLicenseNumber(licenseNumber);
    }
}
}

