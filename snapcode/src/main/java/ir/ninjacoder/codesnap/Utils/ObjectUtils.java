package ir.ninjacoder.codesnap.Utils;
import org.antlr.v4.runtime.Lexer;

public class ObjectUtils {
  public static boolean getNextLexer(Lexer lexer ,char item){
    return lexer._input.LA(1) == item;
  }
}
