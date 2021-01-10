package tk.mwacha.converters;

import io.cucumber.cucumberexpressions.Transformer;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DateConverter implements Transformer<LocalDate> {
    @Override
    public LocalDate transform(String s) throws Throwable {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        formatter = formatter.withLocale( new Locale("pt","BR"));  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        return LocalDate.parse(s, formatter);
    }
}
