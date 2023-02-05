package net.zffu.atlasplus.api.leveling;

public class AtlasLeveling {
	public enum Level {

	    ONE(0),
	    TWO(250),
	    THREE(500),
	    FOUR(750),
	    FIVE(1000),
	    SIX(1500),
	    SEVEN(2000),
	    EIGHT(2500),
	    NINE(3000),
	    TEN(3800),
	    ELEVEN(4600),
	    TWELVE(5400),
	    THIRTEEN(6200),
	    FOURTEEN(7000),
	    FIFTEEN(7800),
	    SIXTEEN(8600),
	    SEVENTEEN(9400),
	    EIGHTEEN(10000),
	    NINETEEN(11000),
	    TWENTY(12000),
	    TWENTY_ONE(13000),
	    TWENTY_TWO(14000),
	    TWENTY_THREE(15000),
	    TWENTY_FOUR(16000),
	    TWENTY_FIVE(17000),
	    TWENTY_SIX(18000),
	    TWENTY_SEVEN(19000),
	    TWENTY_EIGHT(20000),
	    TWENTY_NINE(21500),
	    THIRTY(23000),
	    THIRTY_ONE(24500),
	    THIRTY_TWO(26000),
	    THIRTY_THREE(27500),
	    THIRTY_FOUR(29000),
	    THIRTY_FIVE(31000),
	    THIRTY_SIX(33000),
	    THIRTY_SEVEN(35000),
	    THIRTY_EIGHT(37000),
	    THIRTY_NINE(39000),
	    FOURTY(41000),
	    FOURTY_ONE(43000),
	    FOURTY_TWO(45000),
	    FOURTY_THREE(47000),
	    FOURTY_FOUR(49000),
	    FOURTY_FIVE(52000),
	    FOURTY_SIX(55000),
	    FOURTY_SEVEN(58000),
	    FOURTY_EIGHT(61000),
	    FOURTY_NINE(64000),
	    FIFTY(67000),
	    FIFTY_ONE(70000),
	    FIFTY_TWO(73000),
	    FIFTY_THREE(76000),
	    FIFTY_FOUR(79000),
	    FIFTY_FIVE(82000),
	    FIFTY_SIX(85000),
	    FIFTY_SEVEN(88000),
	    FIFTY_EIGHT(91000),
	    FIFTY_NINE(94000),
	    SIXTY(97000),
	    SIXTY_ONE(100000),
	    SIXTY_TWO(103000),
	    SIXTY_THREE(106000),
	    SIXTY_FOUR(109000),
	    SIXTY_FIVE(112000),
	    SIXTY_SIX(116000),
	    SIXTY_SEVEN(120000),
	    SIXTY_EIGHT(124000),
	    SIXTY_NINE(128000),
	    SEVENTY(132000),
	    SEVENTY_ONE(136000),
	    SEVENTY_TWO(140000),
	    SEVENTY_THREE(144000),
	    SEVENTY_FOUR(148000),
	    SEVENTY_FIVE(152000),
	    SEVENTY_SIX(156000),
	    SEVENTY_SEVEN(160000),
	    SEVENTY_EIGHT(164000),
	    SEVENTY_NINE(168000),
	    EIGHTY(172000),
	    EIGHTY_ONE(177000),
	    EIGHTY_TWO(182000),
	    EIGHTY_THREE(187000),
	    EIGHTY_FOUR(192000),
	    EIGHTY_FIVE(197000),
	    EIGHTY_SIX(202000),
	    EIGHTY_SEVEN(207000),
	    EIGHTY_EIGHT(212000),
	    EIGHTY_NINE(217000),
	    NINETY(222000),
	    NINETY_ONE(227000),
	    NINETY_TWO(232000),
	    NINETY_THREE(237000),
	    NINETY_FOUR(242000),
	    NINETY_FIVE(247000),
	    NINETY_SIX(252000),
	    NINETY_SEVEN(257000),
	    NINETY_EIGHT(262000),
	    NINETY_NINE(267000),
	    ONE_HUNDRED(272000);
		
		private int requiredXp;
		
		private Level(int requiredXp) {
			this.requiredXp = requiredXp;
		}
		
		public int getRequired() {return this.requiredXp;}
		
	}
	
	
	  public static int getLevelFromXP(long xp) {
          Level toReturn = Level.ONE;
          for (Level level : Level.values()) {
                if (level.getRequired() - xp < 0 && ((level.getRequired() - xp) > (toReturn.getRequired() - xp))) {
                      toReturn = level;
                }
          }
          return toReturn.ordinal() + 1;
    }
	


}
