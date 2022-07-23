package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FormatMoney {

  private static final DecimalFormatSymbols REAL = new DecimalFormatSymbols(
    new Locale("pt", "BR")
  );
  private static DecimalFormat decimalFormat = new DecimalFormat(
    "¤ ###,###,##0.00",
    REAL
  );

  public static String format(Double value) {
    return decimalFormat.format(value);
  }
}
