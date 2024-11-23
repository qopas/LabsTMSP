package org.example.Lab3.domain.adapters;

import org.example.Lab3.domain.clases.Device;
import org.example.Lab3.domain.clases.ThirdPartyDevice;

public class ThirdPartyLightAdapter extends Device {
    private ThirdPartyDevice thirdPartyDevice;

    public ThirdPartyLightAdapter(ThirdPartyDevice device) {
        this.thirdPartyDevice = device;
    }

    @Override
    public void turnOn() {
        thirdPartyDevice.activate();
        System.out.println("Adapted: Third-party light turned on.");
    }

    @Override
    public void turnOff() {
        thirdPartyDevice.deactivate();
        System.out.println("Adapted: Third-party light turned off.");
    }
}