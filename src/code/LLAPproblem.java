package code;

public class LLAPproblem {
	private static int budget = 100000;
//	private int waitTime=0;
//	private int tempFood;
//	private int tempMaterials;
//	private int tempEnergy;
	// Class fields for initial values
	private static int initialProsperity;
	private static int initialFood;
	private static int initialMaterials;
	private static int initialEnergy;

	// Class fields for unit prices
	private static int unitPriceFood;
	private static int unitPriceMaterials;
	private static int unitPriceEnergy;

	// Class fields for amount requests and delay requests
	private static int amountRequestFood;
	private static int delayRequestFood;
	private static int amountRequestMaterials;
	private static int delayRequestMaterials;
	private static int amountRequestEnergy;
	private static int delayRequestEnergy;

	// Class fields for BUILD1
	private static int priceBUILD1;
	private static int foodUseBUILD1;
	private static int materialsUseBUILD1;
	private static int energyUseBUILD1;
	private static int prosperityBUILD1;

	// Class fields for BUILD2
	private static int priceBUILD2;
	private static int foodUseBUILD2;
	private static int materialsUseBUILD2;
	private static int energyUseBUILD2;
	private static int prosperityBUILD2;

	public LLAPproblem(String init) {

		String[] parts = init.split(";");

		// Extract and assign values to the class fields
		this.initialProsperity = Integer.parseInt(parts[0]);

		String[] resources = parts[1].split(",");
		this.initialFood = Integer.parseInt(resources[0]);
		this.initialMaterials = Integer.parseInt(resources[1]);
		this.initialEnergy = Integer.parseInt(resources[2]);

		resources = parts[2].split(",");
		this.unitPriceFood = Integer.parseInt(resources[0]);
		this.unitPriceMaterials = Integer.parseInt(resources[1]);
		this.unitPriceEnergy = Integer.parseInt(resources[2]);

		resources = parts[3].split(",");
		this.amountRequestFood = Integer.parseInt(resources[0]);
		this.delayRequestFood = Integer.parseInt(resources[1]);
		
		resources = parts[4].split(",");
		this.amountRequestMaterials = Integer.parseInt(resources[0]);
		this.delayRequestMaterials = Integer.parseInt(resources[1]);
		
		resources = parts[5].split(",");
		this.amountRequestEnergy = Integer.parseInt(resources[0]);
		this.delayRequestEnergy = Integer.parseInt(resources[1]);

		resources = parts[6].split(",");
		this.priceBUILD1 = Integer.parseInt(resources[0]);
		this.foodUseBUILD1 = Integer.parseInt(resources[1]);
		this.materialsUseBUILD1 = Integer.parseInt(resources[2]);
		this.energyUseBUILD1 = Integer.parseInt(resources[3]);
		this.prosperityBUILD1 = Integer.parseInt(resources[4]);

		resources = parts[7].split(",");
		this.priceBUILD2 = Integer.parseInt(resources[0]);
		this.foodUseBUILD2 = Integer.parseInt(resources[1]);
		this.materialsUseBUILD2 = Integer.parseInt(resources[2]);
		this.energyUseBUILD2 = Integer.parseInt(resources[3]);
		this.prosperityBUILD2 = Integer.parseInt(resources[4]);

	}

	public static Node RequestMaterials(Node node) {
		int prosperity = node.getProsperity();
		int food = node.getFood() - 1;
		int material = node.getMaterials() - 1;
		int energy = node.getEnergy() - 1;
		int money_spent = node.getMoney_spent() + unitPriceEnergy + unitPriceFood + unitPriceMaterials;
		int depth = node.getDepth() + 1;
//		if (node.getWait() == 0) {
//			
//			if (node.isRequest_food()) {
//				food += amountRequestFood;
//				node.setRequest_food(false);
//
//			} 
//			if (node.isRequest_energy()) {
//				energy += amountRequestEnergy;
//				node.setRequest_energy(false);
//				
//			}if(node.isRequest_material()){
//				material += amountRequestMaterials;
//				node.setRequest_material(false);
//			}
//
//		}
//		Node newNode = new Node(prosperity, food, material, energy, money_spent, node, depth, 0,"RequestMaterials");
//		//Node newNode = checkWait(node, prosperity, food, material, energy, money_spent, depth,"RequestMaterials");
//
//		newNode.setWait(delayRequestMaterials);
//		newNode.setRequest_material(true);
//		return newNode;
		Node newNode = new Node(prosperity, food, material, energy, money_spent, node, depth, delayRequestMaterials,"RequestMaterials",false,true,false);
		return newNode;
	}

	public static Node RequestEnergy(Node node) {
		int prosperity = node.getProsperity();
		int food = node.getFood() - 1;
		int material = node.getMaterials() - 1;
		int energy = node.getEnergy() - 1;
		int money_spent = node.getMoney_spent() + unitPriceEnergy + unitPriceFood + unitPriceMaterials;
		int depth = node.getDepth() + 1;
//		if (node.getWait() == 0) {
//			
//			if (node.isRequest_food()) {
//				food += amountRequestFood;
//				node.setRequest_food(false);
//
//			} 
//			if (node.isRequest_energy()) {
//				energy += amountRequestEnergy;
//				node.setRequest_energy(false);
//			}if(node.isRequest_material()){
//				material += amountRequestMaterials;
//				node.setRequest_material(false);
//			}
//
//		}
//		Node newNode = new Node(prosperity, food, material, energy, money_spent, node, depth, 0,"RequestEnergy");
//		//Node newNode = checkWait(node, prosperity, food, material, energy, money_spent, depth,"RequestEnergy");
//
//		newNode.setWait(delayRequestEnergy);
//		newNode.setRequest_energy(true);
//		return newNode;
		Node newNode = new Node(prosperity, food, material, energy, money_spent, node, depth, delayRequestEnergy,"RequestEnergy",false,false,true);
		return newNode;

	}

	public static Node RequestFood(Node node) {
		int prosperity = node.getProsperity();
		int food = node.getFood() - 1;
		int material = node.getMaterials() - 1;
		int energy = node.getEnergy() - 1;
		int money_spent = node.getMoney_spent() + unitPriceEnergy + unitPriceFood + unitPriceMaterials;
		int depth = node.getDepth() + 1;
//		//if (node.getWait() == 0) {
////					
////					if (node.isRequest_food()) {
////						food += amountRequestFood;
////						node.setRequest_food(false);
////		
////					} 
////					if (node.isRequest_energy()) {
////						energy += amountRequestEnergy;
////						node.setRequest_energy(false);
////					}
////					if(node.isRequest_material()){
////						material += amountRequestMaterials;
////						node.setRequest_material(false);
////					}
//		
//				//}
		Node newNode = new Node(prosperity, food, material, energy, money_spent, node, depth, delayRequestFood,"RequestFood",true,false,false);
		//Node newNode = checkWait(node, prosperity, food, material, energy, money_spent, depth,"RequestFood");

//		newNode.setWait(delayRequestFood);
//		newNode.setRequest_food(true);
		return newNode;

	}

	public static Node Build1(Node node) {
		int food = node.getFood() - foodUseBUILD1;
		int material = node.getMaterials() - materialsUseBUILD1;
		int energy = node.getEnergy() - energyUseBUILD1;
		int prosperity = node.getProsperity() + prosperityBUILD1;
		int money_spent = node.getMoney_spent() + priceBUILD1 + (foodUseBUILD1 * unitPriceFood)
				+ (energyUseBUILD1 * unitPriceEnergy) + (materialsUseBUILD1 * unitPriceMaterials);
		
		int depth = node.getDepth() + 1;
		if(node.isRequest_energy() ||node.isRequest_material() ||node.isRequest_food()) {
			Node newNode = checkWait(node, prosperity, food, material, energy, money_spent, depth,"Build1");
			
			return newNode;
		}
		Node newNode = new Node(prosperity, food, material, energy, money_spent, node, depth, 0,"Build1");
		return newNode;
	}

	public static Node Build2(Node node) {
		int prosperity = node.getProsperity() + prosperityBUILD2;
		int money_spent = node.getMoney_spent() + priceBUILD2 + (foodUseBUILD2 * unitPriceFood)
				+ (energyUseBUILD2 * unitPriceEnergy) + (materialsUseBUILD2 * unitPriceMaterials);
		int food = node.getFood() - foodUseBUILD2;
		int material = node.getMaterials() - materialsUseBUILD2;
		int energy = node.getEnergy() - energyUseBUILD2;
		int depth = node.getDepth() + 1;
		if(node.isRequest_energy() ||node.isRequest_material() ||node.isRequest_food()) {
			Node newNode = checkWait(node, prosperity, food, material, energy, money_spent, depth,"Build2");
			
			return newNode;
		}
		Node newNode = new Node(prosperity, food, material, energy, money_spent, node, depth, 0,"Build2");
		return newNode;
	}
	public static Node Wait(Node node) {
		
		int prosperity = node.getProsperity();
		int food = node.getFood() - 1;
		int material = node.getMaterials() - 1;
		int energy = node.getEnergy() - 1;
		int money_spent = node.getMoney_spent() + unitPriceEnergy + unitPriceFood + unitPriceMaterials;
		int depth = node.getDepth() + 1;
		Node newNode = checkWait(node, prosperity, food, material, energy, money_spent, depth,"Wait");

		return newNode;

	}

	private static Node checkWait(Node node, int prosperity, int food, int material, int energy, int money_spent, int depth,String nameOfOperator) {
		int wait = node.getWait()-1;
		int check = 0;
		
		if (wait == 0 ){
			
			if (node.isRequest_food()) {
				food += amountRequestFood;
				if(food>50) {
					food=50;
				}
				node.setRequest_food(false);

			} 
			else if (node.isRequest_energy()) {
				energy += amountRequestEnergy;
				if(energy>50) {
					energy=50;
				}
				node.setRequest_energy(false);
				
			} else if(node.isRequest_material()){
				material += amountRequestMaterials;
				if(material>50) {
					material=50;
				}
				node.setRequest_material(false);
			}

		} else {
			
			if(wait > 0 &&( node.isRequest_food() || node.isRequest_energy() || node.isRequest_material())) {

				if (node.isRequest_food()) {
					check = 1;
				} else if (node.isRequest_energy()) {
					check = 2;
				} else if(node.isRequest_material()){
					check = 3;
				}
			}
		}
//		if(wait<0) {
//			Node newNode = new Node(prosperity, food, material, energy, money_spent, node, depth, 0,nameOfOperator);
//			return newNode;
//		}
		Node newNode = new Node(prosperity, food, material, energy, money_spent, node, depth, wait,nameOfOperator);
		switch (check) {
		case 0:
			break;
		case 1:
			newNode.setRequest_food(true);
			
			
			break;
		case 2:
			newNode.setRequest_energy(true);
			break;
		case 3:
			newNode.setRequest_material(true);
			break;
		}
		return newNode;
	}

	public static int getProsperityBUILD1() {
		return prosperityBUILD1;
	}

	public static int getUnitPriceFood() {
		return unitPriceFood;
	}

	public static void setUnitPriceFood(int unitPriceFood) {
		LLAPproblem.unitPriceFood = unitPriceFood;
	}

	public static int getUnitPriceMaterials() {
		return unitPriceMaterials;
	}

	public static void setUnitPriceMaterials(int unitPriceMaterials) {
		LLAPproblem.unitPriceMaterials = unitPriceMaterials;
	}

	public static int getUnitPriceEnergy() {
		return unitPriceEnergy;
	}

	public static void setUnitPriceEnergy(int unitPriceEnergy) {
		LLAPproblem.unitPriceEnergy = unitPriceEnergy;
	}

	public static int getPriceBUILD1() {
		return priceBUILD1;
	}

	public static void setPriceBUILD1(int priceBUILD1) {
		LLAPproblem.priceBUILD1 = priceBUILD1;
	}

	public static int getFoodUseBUILD1() {
		return foodUseBUILD1;
	}

	public static void setFoodUseBUILD1(int foodUseBUILD1) {
		LLAPproblem.foodUseBUILD1 = foodUseBUILD1;
	}

	public static int getMaterialsUseBUILD1() {
		return materialsUseBUILD1;
	}

	public static void setMaterialsUseBUILD1(int materialsUseBUILD1) {
		LLAPproblem.materialsUseBUILD1 = materialsUseBUILD1;
	}

	public static int getEnergyUseBUILD1() {
		return energyUseBUILD1;
	}

	public static void setEnergyUseBUILD1(int energyUseBUILD1) {
		LLAPproblem.energyUseBUILD1 = energyUseBUILD1;
	}

	public static int getPriceBUILD2() {
		return priceBUILD2;
	}

	public static void setPriceBUILD2(int priceBUILD2) {
		LLAPproblem.priceBUILD2 = priceBUILD2;
	}

	public static int getFoodUseBUILD2() {
		return foodUseBUILD2;
	}

	public static void setFoodUseBUILD2(int foodUseBUILD2) {
		LLAPproblem.foodUseBUILD2 = foodUseBUILD2;
	}

	public static int getMaterialsUseBUILD2() {
		return materialsUseBUILD2;
	}

	public static void setMaterialsUseBUILD2(int materialsUseBUILD2) {
		LLAPproblem.materialsUseBUILD2 = materialsUseBUILD2;
	}

	public static int getEnergyUseBUILD2() {
		return energyUseBUILD2;
	}

	public static void setEnergyUseBUILD2(int energyUseBUILD2) {
		LLAPproblem.energyUseBUILD2 = energyUseBUILD2;
	}

	public static void setProsperityBUILD1(int prosperityBUILD1) {
		LLAPproblem.prosperityBUILD1 = prosperityBUILD1;
	}

	public static int getProsperityBUILD2() {
		return prosperityBUILD2;
	}

	public static void setProsperityBUILD2(int prosperityBUILD2) {
		LLAPproblem.prosperityBUILD2 = prosperityBUILD2;
	}

	public static int getBudget() {
		return budget;
	}

	public  void setBudget(int budget) {
		this.budget = budget;
	}

	public static int getInitialProsperity() {
		return initialProsperity;
	}

	public static int getInitialFood() {
		return initialFood;
	}

	public static int getInitialMaterials() {
		return initialMaterials;
	}

	public static int getInitialEnergy() {
		return initialEnergy;
	}

}
