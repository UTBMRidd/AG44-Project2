package fr.cedric.components;

public enum RouteType {
	


	
	  TK("Ski lift","TK",1,4),
	  TS("Char lift","TS",1,4),
	  TSD("Special chair lift","TSD",1,3),
	  TC("Cabine","TC",2,3),
	  TPH("Telepheric","TPH",4,2),
	  BUS1("Shuttle bus 1","BUS1",30,0),
	  BUS2("Shuttle bus 2","BUS2",40,0),
	  V("Green piste","V",0,5),
	  B("Blue piste","B",0,4),
	  R("Red piste","R",0,3),
	  N("Black piste","N",0,2),
	  KL("Track skiing","KL",0,1/6),
	  SURF("Surfing","SURF",0,10);
	  
	  
	
		private String name = "";
		private String alias = "";
		private float fixedT,dT;
		
		RouteType(String name,String alias, float fixedT,float dT){
			this.name = name;
			this.alias = alias;
			this.fixedT = fixedT;
			this.dT = dT;
			
		}

		public String getName() {
			return name;
		}

		public float getFixedT() {
			return fixedT;
		}

		public float getdT() {
			return dT;
		}

		public String getAlias() {
			return alias;
		}


}
