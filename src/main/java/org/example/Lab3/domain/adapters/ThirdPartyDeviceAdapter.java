package org.example.Lab3.domain.adapters;

import org.example.Lab3.domain.clases.Device;
import org.example.Lab3.domain.clases.ThirdPartyDevice;

public class ThirdPartyDeviceAdapter extends Device {
    private ThirdPartyDevice thirdPartyDevice;

    public ThirdPartyDeviceAdapter(ThirdPartyDevice device) {
        this.thirdPartyDevice = device;
    }

    @Override
    public void turnOn() {
        thirdPartyDevice.activate();
    }

    @Override
    public void turnOff() {
        thirdPartyDevice.deactivate();
    }
}