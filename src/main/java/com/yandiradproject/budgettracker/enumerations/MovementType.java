
package com.yandiradproject.budgettracker.enumerations;

/**
 *
 * @author yandirad
 */
public enum MovementType {
    FIXED_EXPENSE("Fixed Expense"), VARIABLE_EXPENSE("Variable Expense"), 
    REGULAR_INCOME("Regular Income"), IRREGULAR_INCOME("Irregular Income"), SAVING("Saving");
    
    private String value;
    
    private MovementType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
}
