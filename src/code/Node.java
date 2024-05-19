package code;

import java.util.Objects;

public class Node {

	private int prosperity, food, materials, energy, money_spent;
	private String nameOfOperator;
	private int depth;
	private Node parent;
	private int wait = 0;
	private int heuristic;
	private int FoodRequest = 0;
	private int MaterialRequest = 0;
	private int EnergyRequest = 0;
	private boolean request_food, request_material, request_energy = false;

	public int getProsperity() {
		return prosperity;
	}

	public void setProsperity(int prosperity) {
		this.prosperity = prosperity;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getMaterials() {
		return materials;
	}

	public void setMaterials(int materials) {
		this.materials = materials;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getMoney_spent() {
		return money_spent;
	}

	public void setMoney_spent(int money_spent) {
		this.money_spent = money_spent;
	}

	public Node(int prosperity, int food, int materials, int energy, int money_spent, Node parent, int depth, int wait,
			String nameOfOperator) {
		super();
		this.prosperity = prosperity;
		this.food = food;
		this.materials = materials;
		this.energy = energy;
		this.money_spent = money_spent;
		this.parent = parent;
		this.depth = depth;
		this.wait = wait;
		this.nameOfOperator = nameOfOperator;

	}

	public Node(int prosperity, int food, int materials, int energy, int money_spent, int depth, int wait,
			String nameOfOperator) {
		super();
		this.prosperity = prosperity;
		this.food = food;
		this.materials = materials;
		this.energy = energy;
		this.money_spent = money_spent;
		this.depth = depth;
		this.wait = wait;
		this.nameOfOperator = nameOfOperator;
	}

	public Node(int prosperity, int food, int materials, int energy, int money_spent, Node parent, int depth, int wait,
			String nameOfOperator, boolean foodRequest, boolean materialRequest, boolean energyRequest) {
		super();
		this.prosperity = prosperity;
		this.food = food;
		this.materials = materials;
		this.energy = energy;
		this.money_spent = money_spent;
		this.parent = parent;
		this.depth = depth;
		this.wait = wait;
		this.nameOfOperator = nameOfOperator;
		this.request_food = foodRequest;
		this.request_material = materialRequest;
		this.request_energy = energyRequest;
		if (foodRequest) {
			FoodRequest = 1;
		}
		if (materialRequest) {
			MaterialRequest = 1;
		}
		if (energyRequest) {
			EnergyRequest = 1;
		}

	}

	public static void main(String[] args) {

	}

	public int getWait() {
		return wait;
	}

	public void setWait(int wait) {
		this.wait = wait;
	}

	public boolean isRequest_food() {
		return request_food;
	}

	public void setRequest_food(boolean request_food) {
		this.request_food = request_food;
		if (request_food) {
			FoodRequest = 1;
		} else {
			FoodRequest = 0;
		}
	}

	public boolean isRequest_material() {
		return request_material;
	}

	public void setRequest_material(boolean request_material) {
		this.request_material = request_material;

		if (request_material) {
			MaterialRequest = 1;
		} else {
			MaterialRequest = 0;
		}

	}

	public boolean isRequest_energy() {
		return request_energy;
	}

	public void setRequest_energy(boolean request_energy) {
		this.request_energy = request_energy;
		if (request_energy) {
			EnergyRequest = 1;
		} else {
			EnergyRequest = 0;
		}
	}

	public int getDepth() {
		return depth;
	}

	public Node getParent() {
		return parent;
	}

	public String getNameOfOperator() {
		return nameOfOperator;
	}

	public void setNameOfOperator(String nameOfOperator) {
		this.nameOfOperator = nameOfOperator;
	}

	public int getHeuristic() {
		return heuristic;
	}

	public void setHeuristic(int heuristic) {
		this.heuristic = heuristic;
	}

	@Override
	public int hashCode() {
		return Objects.hash(materials, energy,wait);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Node other = (Node) obj;

		// Add your comparison logic here
		if ((other.food > this.food ||
				
		// other.materials > this.materials ||
		// other.energy > this.energy ||
				other.prosperity > this.prosperity
			|| (other.money_spent < this.money_spent && ((other.prosperity < this.prosperity && other.food < this.food)))
			||(other.money_spent >= this.money_spent && (other.prosperity > this.prosperity
					|| other.money_spent < this.money_spent || this.request_food != other.request_food
					|| this.request_material != other.request_material
					|| this.request_energy != other.request_energy))

				|| this.request_food != other.request_food || this.request_material != other.request_material
				|| this.request_energy != other.request_energy)
				|| (other.food == this.food && (other.prosperity > this.prosperity
						|| other.money_spent < this.money_spent || this.request_food != other.request_food
						|| this.request_material != other.request_material
						|| this.request_energy != other.request_energy)))
			
		// ||
		// other.wait < this.wait

		 {
			return false; // Objects are not equal
		} else {
			return true; // Objects are equal
		}
	}

	// @Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (obj == null || getClass() != obj.getClass()) {
//			return false;
//		}
//		Node comingState = (Node) obj;
//
//		// Add your comparison logic here
//		return (this.energy <= comingState.energy && this.food <= comingState.food && this.materials <= comingState.materials &&
//				this.prosperity <= comingState.prosperity && 
//				this.wait >= comingState.wait && this.money_spent >= comingState.money_spent);
//	
//	}
}
