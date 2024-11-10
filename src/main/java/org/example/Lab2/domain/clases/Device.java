package org.example.Lab2.domain.clases;

/**
 * Device is an abstract class representing a general smart device in the system.
 */
public abstract class Device {
    protected String name;
    protected boolean status;
    public abstract void turnOn();
    public abstract void turnOff();

    public String getStatus() {
        return status? "ON" : "OFF";
    }

    public String getName() {
        return name;
    }

    public void setStatus(boolean turnOn) {
        this.status = turnOn;
    }

    /**
     * Nested static Builder class that provides a common template for building devices.
     *
     * @param <T> The type parameter for the builder to support method chaining in subclasses.
     */
    public abstract static class Builder<T extends Builder<T>> {
        protected String name;
        protected boolean status;

        public T name(String name) {
            this.name = name;
            return (T) this;
        }

        public T status(boolean status) {
            this.status = status;
            return (T) this;
        }

        public abstract Device build();
    }

    @Override
    public String toString() {
        return "Device{name='" + name + "', status=" + status + "}";
    }
}

