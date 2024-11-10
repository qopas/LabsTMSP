package org.example.Lab2.domain.clases;


/**
 * Simulates a third-party device without Device interface
 */

public class ThirdPartyDevice {
    public void activate() {
        System.out.println("Third-party device activated.");
    }
    public void deactivate() {
        System.out.println("Third-party device deactivated.");
    }
}