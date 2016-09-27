package restaurante;

public enum TiposDePrato {
	ENTRADA ("entrada"),
	PRATO_PRINCIPAL ("prato principal"), 
    SOBREMESA ("sobremesa"), 
    PETIT_FOUR ("petit four");
  
     
    private String tipo;
    private TiposDePrato(String emString){
          this.tipo = emString;
       }
 
    public String getTipo(){
    	return this.tipo;
    }
    
    @Override
    public String toString()
       {
          return this.tipo; 
       }
}
