package com.umitakbulut.duty_pharmacy.external.dutypharmacy;

import com.umitakbulut.duty_pharmacy.external.dutypharmacy.model.DutyPharmacyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "duty-pharmacy", url = "${application.external-service.url}")
public interface DutyPharmacyExternalService {
    @GetMapping("/dutyPharmacy")
    DutyPharmacyResponse getDutyPharmacy(@RequestParam(name = "ilce") String districtName,
                                         @RequestParam(name = "il") String cityName,
                                         @RequestHeader(name = "authorization") String apikey);
}
