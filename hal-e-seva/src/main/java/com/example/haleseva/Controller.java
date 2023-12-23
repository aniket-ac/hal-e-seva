package com.example.haleseva;

import com.example.haleseva.pojos.LocationRequestPOJO;
import com.example.haleseva.pojos.LocationResponsePOJO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Service service = new Service();

    @PostMapping("/v1/get_location_data")
    public @ResponseBody LocationResponsePOJO getLocationData(final @RequestBody LocationRequestPOJO requestPOJO) {
        return service.callClima(requestPOJO);
    }
}
