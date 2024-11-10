package org.example.Lab2.domain.clases;

/**
 * Thermostat is a concrete subclass of Device representing a smart thermostat.
 */
public class Thermostat extends Device {
    private int temperature;

    private Thermostat() {}

    /**
     * Nested static Builder class for constructing a Thermostat instance with custom properties.
     */
    public static class Builder extends Device.Builder<Builder> {
        private int temperature = 20; // Default temperature

        public Builder temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        @Override
        public Thermostat build() {
            Thermostat thermostat = new Thermostat();
            thermostat.name = this.name;
            thermostat.status = this.status;
            thermostat.temperature = this.temperature;
            return thermostat;
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println(name + " temperature set to " + temperature + " degrees.");
    }


    @Override
    public String toString() {
        return "Thermostat{name='" + name + "', status=" + status + ", temperature=" + temperature + "}";
    }
    @Override
    public void turnOn() {
        status = true;
        System.out.println(name + " is now ON at " + temperature + "°C.");
    }

    @Override
    public void turnOff() {
        status = false;
        System.out.println(name + " is now OFF.");
    }
}