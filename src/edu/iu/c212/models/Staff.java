package edu.iu.c212.models;

import java.util.Objects;

public class Staff {
    private String fullName;
    private int age;
    private String role; // Full name like "Manager", "Cashier", "Gardener"
    private String availability;

    public Staff(String fullName, int age, String role, String availability) {
        validateFullName(fullName);
        validateAge(age);
        this.fullName = fullName;
        this.age = age;
        this.role = convertRoleToFullName(role);
        this.availability = availability;
    }

    private void validateFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be null or empty.");
        }
    }

    private void validateAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive.");
        }
    }

    private String convertRoleToFullName(String role) {
        switch (role) {
            case "M": return "Manager";
            case "C": return "Cashier";
            case "G": return "Gardener";
            default: throw new IllegalArgumentException("Invalid role provided.");
        }
    }

    // Getter and setter methods
    public String getName() { return fullName; }
    public void setName(String fullName) { this.fullName = fullName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = convertRoleToFullName(role); }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return age == staff.age &&
                Objects.equals(fullName, staff.fullName) &&
                Objects.equals(role, staff.role) &&
                Objects.equals(availability, staff.availability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, age, role, availability);
    }

    @Override
    public String toString() {
        return String.format("Staff{fullName='%s', age=%d, role='%s', availability='%s'}", fullName, age, role, availability);
    }
}
