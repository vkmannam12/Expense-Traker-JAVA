package com.expensetracker.service;

import com.expensetracker.model.Expense;
import com.expensetracker.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    private ArrayList<Expense> expenses = new ArrayList<>();

    public ExpenseService() {
        loadExpenses();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveExpenses();
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public List<Expense> getExpensesByCategory(String category) {
        List<Expense> filtered = new ArrayList<>();
        for (Expense e : expenses) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                filtered.add(e);
            }
        }
        return filtered;
    }

    public double calculateTotalExpenses() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    public void loadExpenses() {
        expenses = new ArrayList<>(FileUtil.readFromFile());
    }

    public void saveExpenses() {
        FileUtil.writeToFile(expenses);
    }
}