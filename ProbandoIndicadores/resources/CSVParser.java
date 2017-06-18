package domain.parser;
import java.util.List;

import com.univocity.parsers.annotations.*;
import com.univocity.parsers.annotations.Parsed;
import domain.stockObjects.Account;

public class CSVParser {
	 // if the value parsed in the quantity column is "?" or "-", it will be replaced by null.
    @NullString(nulls = { "?", "-" })
    // if a value resolves to null, it will be converted to the String "0".
    @Parsed(defaultNullRead = "0")
    private Integer quantity;   // The attribute type defines which conversion will be executed when processing the value.

    @Trim
    @LowerCase
    // the value for the comments attribute is in the column at index 4 (0 is the first column, so this means fifth column in the file)
    @Parsed(index = 0)
    private String title;
    @Parsed(index = 1)
    private String description;
    @Parsed(index = 2)
    private Account account;
    @Parsed(index = 3)
    private String name;  
    @Parsed(index = 4)
    private int value;
    @Parsed(index = 5)
    private int year;

    @Trim
    @LowerCase
    // values "no", "n" and "null" will be converted to false; values "yes" and "y" will be converted to true
    @BooleanString(falseStrings = { "no", "n", "null" }, trueStrings = { "yes", "y" })
    @Parsed
    private Boolean pending;
}
