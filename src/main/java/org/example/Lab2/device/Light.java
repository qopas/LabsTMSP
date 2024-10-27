package org.example.Lab2.device;

/**
 * Light is a concrete subclass of Device representing a smart light.
 */
public class Light extends Device {
    private int brightness;

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

    @Override
    public String toString() {
        return "Light{name='" + name + "', status=" + status + ", brightness=" + brightness + "}";
    }
}