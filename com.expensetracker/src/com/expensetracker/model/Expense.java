package com.expensetracker.model;

public class Expense {
    private String description;
    private double amount;
    private String category;

    // Constructor
    public Expense(String description, double amount, String category) {
        if (description == null || description.isEmpty() ||
            category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Description and category cannot be empty.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }

        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    // Convert to display format
    @Override
    public String toString() {
        return description + " - " + amount + " (" + category + ")";
    }

    // Convert to CSV
    public String toCSV() {
        return description + "," + amount + "," + category;
    }

    // Convert CSV to object
    public static Expense parseExpense(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid CSV format: " + line);
        }

        String description = parts[0];
        double amount = Double.parseDouble(parts[1]);
        String category = parts[2];

        return new Expense(description, amount, category);
    }
}