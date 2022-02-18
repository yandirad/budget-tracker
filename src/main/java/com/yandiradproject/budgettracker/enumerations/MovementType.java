
package com.yandiradproject.budgettracker.enumerations;

/**
 *
 * @author yandirad
 */
public enum MovementType {
    FIXED_EXPENSE(0, "Fixed Expense"), VARIABLE_EXPENSE(1, "Variable Expense"), 
    REGULAR_INCOME(2, "Regular Income"), IRREGULAR_INCOME(3, "Irregular Income"), SAVING(4, "Saving");
    
    private String value;
    private Integer code;
    
    private MovementType(Integer code, String value){
        this.code = code;
        this.value = value;
    }
    
    public Integer getCode(){
        return code;
    }

    public String getValue() {
        return value;
    }
    
}
