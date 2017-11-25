import java.util.HashMap;
import java.util.Map;

public class ExpressionHandler {

    private String expression;
    private Boolean[][] truthTable;
    private TruthTableGenerator truthTableGenerator;
    private Boolean tautology;
    private  Boolean contradiction;
    private int numberOfVariables;

    public ExpressionHandler(String expression){
        this.expression = expression;
        truthTable = null;
        tautology = false;
        contradiction = false;
        numberOfVariables = getNumberOfVariables();
        truthTableGenerator = new TruthTableGenerator(calcRows(), calcCols());
    }

    private int calcRows() {
        int pow2 = 1;
        for(int i=0; i<numberOfVariables; i++)
            pow2 *= 2;
        return pow2;
    }

    private int calcCols() {
        return numberOfVariables + 1;
    }

    public int getNumberOfVariables() {
        Map<Character, Integer> freq = new HashMap<>();
        for(Character c : expression.toCharArray()){
            if(Character.isAlphabetic(c) && !c.equals('v') && !c.equals('V')){
                if(freq.containsKey(c)){
                    freq.put(c, freq.get(c) + 1);
                }
                else{
                    freq.put(c, 1);
                }
            }
        }
        return freq.size();
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public Boolean[][] getTruthTable(){
        if(truthTable != null)
            return truthTable;
        return truthTableGenerator.generateTruthTable(this.expression);
    }

    public void testTautology(){

    }

    public void testContradiction(){

    }

    public Boolean isTautology(){
        return this.tautology;
    }

    public Boolean isContradiction(){
        return this.contradiction;
    }
}