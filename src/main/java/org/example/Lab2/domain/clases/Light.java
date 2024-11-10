package org.example.Lab2.domain.clases;

/**
 * Light is a concrete subclass of Device representing a smart light.
 */
public class Light extends Device implements PowerSavingDevice{
    private int brightness;

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
    private boolean powerSavingEnabled;

    /**
     * Nested static Builder class for constructing a Light instance with custom properties.
     */
    public static class Builder extends Device.Builder<Builder> {
        private int brightness = 0;

        public Builder brightness(int brightness) {
            this.brightness = brightness;
            return this;
        }

        @Override
        public Light build() {
            Light light = new Light();
            light.name = this.name;
            light.status = this.status;
            light.brightness = this.brightness;
            return light;
        }
    }
    public int getBrightness() {
        return brightness;
    }
    public boolean isPowerSavingEnabled() {
        return powerSavingEnabled;
    }
    @Override
    public String toString() {
        return "Light{name='" + name + "', status=" + status + ", brightness=" + brightness + "}";
    }
    @Override
    public void turnOn() {
        System.out.println(name + " turned on. Brightness: " + brightness);
    }

    @Override
    public void turnOff() {
        System.out.println(name + " turned off.");
    }
    @Override
    public void enablePowerSaving() {
        this.powerSavingEnabled = true;
        System.out.println(getName() + " power-saving mode enabled.");
        // Adjust the brightness for power-saving (e.g., reduce it)
        setBrightness(30); // Reduce brightness to 30% when power-saving is enabled
    }

    @Override
    public void disablePowerSaving() {
        this.powerSavingEnabled = false;
        System.out.println(getName() + " power-saving mode disabled.");
        // Restore brightness to a default value
        setBrightness(100); // Restore brightness to 100%
    }

    public void performAction() {
        System.out.println(getName() + " performing action with brightness " + getBrightness() + "%.");
    }
}