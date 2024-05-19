package code;

import java.util.*;
import java.math.*;

// prosperity, moneyspent of yhe entering is less than i have 
public class GenericSearch extends LLAPproblem {
	private static boolean FoodFull = false;;
	private static boolean EnergyFull = false;
	private static boolean MaterialFull = false;

	public GenericSearch(String init) {
		super(init);

		// TODO Auto-generated constructor stub
	}

	private static boolean Final = false;
	public static int nodes_expanded = 0;

	// ******* Breadth First Search **********
	public static Node BFS(Node node) {
		Node Fail = node;
		HashSet<Node> VisitedNodes = new HashSet<Node>(); // for checking repeated states no 2 nodes are the
																	// same ,Nodes expanded in result
		Queue q = new Queue(100000000);
		Node x;
		VisitedNodes.add(node);
		q.enqueue(new NodeUpdated(node, "RequestFood"));
		q.enqueue(new NodeUpdated(node, "RequestMaterials"));
		q.enqueue(new NodeUpdated(node, "RequestEnergy"));
		q.enqueue(new NodeUpdated(node, "Build1"));
		q.enqueue(new NodeUpdated(node, "Build2"));

		while (!q.isEmpty(q)) {
			NodeUpdated n = q.dequeue();

			Node A = n.getNode();

			// if(!isContainNode(VisitedNodes,A))
			// {
			switch (n.getS()) {
			case "RequestFood":
				x = RequestFood(A);
				if (check_validity2(A)) {
				if (!VisitedNodes.contains(x)) {
					VisitedNodes.add(x);

					if (x.getMoney_spent() < 100000) {
						q.enqueue(new NodeUpdated(x, "Build1"));
						q.enqueue(new NodeUpdated(x, "Build2"));
						q.enqueue(new NodeUpdated(x, "Wait"));
					}
				}}
				break;
			case "RequestMaterials":
				x = RequestMaterials(A);
				if (check_validity2(A)) {
				if (!VisitedNodes.contains(x)) {
					VisitedNodes.add(x);

					if (x.getMoney_spent() < 100000) {
						q.enqueue(new NodeUpdated(x, "Build1"));
						q.enqueue(new NodeUpdated(x, "Build2"));
						q.enqueue(new NodeUpdated(x, "Wait"));
					}
				}}
				break;
			case "RequestEnergy":
				x = RequestEnergy(A);
				if (check_validity2(A)) {
				if (!VisitedNodes.contains(x)) {
					VisitedNodes.add(x);

					if (x.getMoney_spent() < 100000) {
						q.enqueue(new NodeUpdated(x, "Build1"));
						q.enqueue(new NodeUpdated(x, "Build2"));
						q.enqueue(new NodeUpdated(x, "Wait"));
					}
				}}
				break;
			case "Build1":
				if (check_validity(A, true)) {
					x = Build1(A);

					if (x.getWait() >= 1) {
						if (!VisitedNodes.contains(x)) {
							VisitedNodes.add(x);

							if (x.getProsperity() >= 100) {
								nodes_expanded = VisitedNodes.size();
								return x;
							}
							if (x.getMoney_spent() < 100000) {
								q.enqueue(new NodeUpdated(x, "Build1"));
								q.enqueue(new NodeUpdated(x, "Build2"));
								q.enqueue(new NodeUpdated(x, "Wait"));
							}
						}
					} else {
						if (!VisitedNodes.contains(x)) {
							VisitedNodes.add(x);

							if (x.getProsperity() >= 100) {
								nodes_expanded = VisitedNodes.size();
								return x;
							}
							if (x.getMoney_spent() < 100000) {
								q.enqueue(new NodeUpdated(x, "RequestFood"));
								q.enqueue(new NodeUpdated(x, "RequestMaterials"));
								q.enqueue(new NodeUpdated(x, "RequestEnergy"));
								q.enqueue(new NodeUpdated(x, "Build1"));
								q.enqueue(new NodeUpdated(x, "Build2"));

							}
						}
					}
				}
				break;
			case "Build2":
				if (check_validity(A, false)) {
					x = Build2(A);

					if (x.getWait() >= 1) {
						if (!VisitedNodes.contains(x)) {
							VisitedNodes.add(x);

							if (x.getProsperity() >= 100) {
								nodes_expanded = VisitedNodes.size();
								return x;
							}
							if (x.getMoney_spent() < 100000) {
								q.enqueue(new NodeUpdated(x, "Build1"));
								q.enqueue(new NodeUpdated(x, "Build2"));
								q.enqueue(new NodeUpdated(x, "Wait"));
							}
						}
					} else {
						if (!VisitedNodes.contains(x)) {
							VisitedNodes.add(x);

							if (x.getProsperity() >= 100) {
								nodes_expanded = VisitedNodes.size();
								return x;
							}
							if (x.getMoney_spent() < 100000) {
								q.enqueue(new NodeUpdated(x, "RequestFood"));
								q.enqueue(new NodeUpdated(x, "RequestMaterials"));
								q.enqueue(new NodeUpdated(x, "RequestEnergy"));
								q.enqueue(new NodeUpdated(x, "Build1"));
								q.enqueue(new NodeUpdated(x, "Build2"));

							}
						}
					}
				}
				break;
			case "Wait":
				x = Wait(A);
				if (check_validity2(x)) {
					if (x.getWait() >= 1) {
						if (!VisitedNodes.contains(x)) {
							VisitedNodes.add(x);

							if (x.getMoney_spent() < 100000) {
								q.enqueue(new NodeUpdated(x, "Build1"));
								q.enqueue(new NodeUpdated(x, "Build2"));
								q.enqueue(new NodeUpdated(x, "Wait"));
							}
						}
					} else {
						if (!VisitedNodes.contains(x)) {
							VisitedNodes.add(x);

							if (x.getMoney_spent() < 100000) {
								q.enqueue(new NodeUpdated(x, "RequestFood"));
								q.enqueue(new NodeUpdated(x, "RequestMaterials"));
								q.enqueue(new NodeUpdated(x, "RequestEnergy"));
								q.enqueue(new NodeUpdated(x, "Build1"));
								q.enqueue(new NodeUpdated(x, "Build2"));
							}
						}
					}

					break;

				}
			}
			// }

		}

		return Fail;

	}

	// ******* Depth First Search **********

	public static Node DFS(Node node) {
		Node Fail = node;
		HashSet<Node> VisitedNodes = new HashSet<Node>();
		Stack S = new Stack();
		Node x;
		VisitedNodes.add(node);
		S.push(new NodeUpdated(node, "Build2"));
		S.push(new NodeUpdated(node, "Build1"));
		S.push(new NodeUpdated(node, "RequestEnergy"));
		S.push(new NodeUpdated(node, "RequestMaterials"));
		S.push(new NodeUpdated(node, "RequestFood"));
		while (!S.isEmpty()) {
			NodeUpdated n = S.pop();

			Node A = n.getNode();
			
			// if(!isContainNode(VisitedNodes,A))
			// {
			switch (n.getS()) {
			case "RequestFood":
				x = RequestFood(A);
				if (check_validity2(A)) {
					if (!VisitedNodes.contains(x)) {
						VisitedNodes.add(x);
						if (x.getMoney_spent() < 100000) {
							S.push(new NodeUpdated(x, "Wait"));
							S.push(new NodeUpdated(x, "Build2"));
							S.push(new NodeUpdated(x, "Build1"));

						}
					}
				}
				break;
			case "RequestMaterials":
				x = RequestMaterials(A);
				if (check_validity2(A)) {
					if (!VisitedNodes.contains(x)) {
						VisitedNodes.add(x);
						if (x.getMoney_spent() < 100000) {
							S.push(new NodeUpdated(x, "Wait"));
							S.push(new NodeUpdated(x, "Build2"));
							S.push(new NodeUpdated(x, "Build1"));
						}
					}
				}
				break;
			case "RequestEnergy":
				x = RequestEnergy(A);
				if (check_validity2(A)) {
					if (!VisitedNodes.contains(x)) {
						VisitedNodes.add(x);
						if (x.getMoney_spent() < 100000) {
							S.push(new NodeUpdated(x, "Wait"));
							S.push(new NodeUpdated(x, "Build2"));
							S.push(new NodeUpdated(x, "Build1"));
						}
					}
				}
				break;
			case "Build1":
				if (check_validity(A, true)) {
					//System.out.println("I WILL BUILD NAAW" +" Energy "+ A.getEnergy() +" Food "+A.getFood()+ " Materials "+A.getMaterials());
					x = Build1(A);

					if (x.getWait() >= 1) {
						if (!VisitedNodes.contains(x)) {
							VisitedNodes.add(x);
							if (x.getProsperity() >= 100) {
								nodes_expanded = VisitedNodes.size() - 1;
								return x;
							}
							if (x.getMoney_spent() < 100000) {
								S.push(new NodeUpdated(x, "Wait"));
								S.push(new NodeUpdated(x, "Build2"));
								S.push(new NodeUpdated(x, "Build1"));
							}
						}
					} else {
						if (!VisitedNodes.contains(x)) {
							VisitedNodes.add(x);
							if (x.getProsperity() >= 100) {
								nodes_expanded = VisitedNodes.size() - 1;
								return x;
							}
							if (x.getMoney_spent() < 100000) {

								S.push(new NodeUpdated(x, "Build2"));
								S.push(new NodeUpdated(x, "Build1"));
								S.push(new NodeUpdated(x, "RequestEnergy"));
								S.push(new NodeUpdated(x, "RequestMaterials"));
								S.push(new NodeUpdated(x, "RequestFood"));
							}
						}
					}
				}
				break;
			case "Build2":
				if (check_validity(A, false)) {
					x = Build2(A);

					if (x.getWait() >= 1) {
						if (!VisitedNodes.contains(x)) {
							VisitedNodes.add(x);
							if (x.getProsperity() >= 100) {
								nodes_expanded = VisitedNodes.size() - 1;
								return x;
							}
							if (x.getMoney_spent() < 100000) {
								S.push(new NodeUpdated(x, "Wait"));
								S.push(new NodeUpdated(x, "Build2"));
								S.push(new NodeUpdated(x, "Build1"));
							}
						}
					} else {
						if (!VisitedNodes.contains(x)) {
							VisitedNodes.add(x);
							if (x.getProsperity() >= 100) {
								nodes_expanded = VisitedNodes.size() - 1;
								return x;
							}
							if (x.getMoney_spent() < 100000) {

								S.push(new NodeUpdated(x, "Build2"));
								S.push(new NodeUpdated(x, "Build1"));
								S.push(new NodeUpdated(x, "RequestEnergy"));
								S.push(new NodeUpdated(x, "RequestMaterials"));
								S.push(new NodeUpdated(x, "RequestFood"));
							}
						}
					}
				}
				break;
			case "Wait":

				x = Wait(A);
				if (check_validity2(x)) {
					if (x.getWait() >= 1) {
						if (!VisitedNodes.contains(x)) {
							VisitedNodes.add(x);
							if (x.getMoney_spent() < 100000) {
								S.push(new NodeUpdated(x, "Wait"));
								S.push(new NodeUpdated(x, "Build2"));
								S.push(new NodeUpdated(x, "Build1"));
							}
						}
					} else {
						if (!VisitedNodes.contains(x)) {
							VisitedNodes.add(x);
							if (x.getMoney_spent() < 100000) {

								S.push(new NodeUpdated(x, "Build2"));
								S.push(new NodeUpdated(x, "Build1"));
								S.push(new NodeUpdated(x, "RequestEnergy"));
								S.push(new NodeUpdated(x, "RequestMaterials"));
								S.push(new NodeUpdated(x, "RequestFood"));
							}
						}
					}

					break;

				}
			}
			// }

		}

		return Fail;
	}

	// ******* Iteravtive deepening Search **********
	public static Node ID(Node node) {
		for (double depth = 0; depth < Double.POSITIVE_INFINITY; depth++) {

			Node x = DepthLimited(node, depth);
			if (x.getProsperity() >= 100) {
				return x;
			}
			if (Final) {
				return node;
			}
		}

		return node;
	}

	// ******* Depth Limited Search **********
	public static Node DepthLimited(Node node, double Depth) {
		Final = true;
		Stack S = new Stack();
		Node Fail = node;
		HashSet<Node> VisitedNodes = new HashSet<Node>();
		Node x;
		VisitedNodes.add(node);
		if (Depth == 0) {
			Final = false;
			return node;

		} else {

			S.push(new NodeUpdated(node, "Build2"));
			S.push(new NodeUpdated(node, "Build1"));
			S.push(new NodeUpdated(node, "RequestEnergy"));
			S.push(new NodeUpdated(node, "RequestMaterials"));
			S.push(new NodeUpdated(node, "RequestFood"));
			while (!S.isEmpty()) {
				NodeUpdated n = S.pop();

				Node A = n.getNode();

				// if(!isContainNode(VisitedNodes,A))
				// {
				switch (n.getS()) {
				case "RequestFood":
					x = RequestFood(A);
					if (check_validity2(A)) {
					if (!VisitedNodes.contains(x)) {
						VisitedNodes.add(x);

						if (x.getMoney_spent() < 100000 && x.getDepth() < (int) Depth) {
							S.push(new NodeUpdated(x, "Wait"));
							S.push(new NodeUpdated(x, "Build2"));
							S.push(new NodeUpdated(x, "Build1"));

						}
					} else if (x.getDepth() == (int) Depth) {
						Final = false;
					}}
					break;
				case "RequestMaterials":
					x = RequestMaterials(A);
					if (check_validity2(A)) {
					if (!VisitedNodes.contains(x)) {
						VisitedNodes.add(x);
						if (x.getMoney_spent() < 100000 && x.getDepth() < (int) Depth) {
							S.push(new NodeUpdated(x, "Wait"));
							S.push(new NodeUpdated(x, "Build2"));
							S.push(new NodeUpdated(x, "Build1"));

						} else if (x.getDepth() == (int) Depth) {
							Final = false;
						}
					}}
					break;
				case "RequestEnergy":
					x = RequestEnergy(A);
					if (check_validity2(x)) {
					if (!VisitedNodes.contains(x)) {
						VisitedNodes.add(x);
						if (x.getMoney_spent() < 100000 && x.getDepth() < (int) Depth) {
							S.push(new NodeUpdated(x, "Wait"));
							S.push(new NodeUpdated(x, "Build2"));
							S.push(new NodeUpdated(x, "Build1"));

						} else if (x.getDepth() == (int) Depth) {
							Final = false;
						}
					}}
					break;
				case "Build1":
					if (check_validity(A, true)) {
						x = Build1(A);

						if (!VisitedNodes.contains(x)) {
							if (x.getWait() >= 1) {

								VisitedNodes.add(x);
								if (x.getProsperity() >= 100) {
									nodes_expanded = VisitedNodes.size();
									return x;
								}
								if (x.getMoney_spent() < 100000 && x.getDepth() < (int) Depth) {
									S.push(new NodeUpdated(x, "Wait"));
									S.push(new NodeUpdated(x, "Build2"));
									S.push(new NodeUpdated(x, "Build1"));

								}
							} else {

								VisitedNodes.add(x);
								if (x.getProsperity() >= 100) {
									nodes_expanded = VisitedNodes.size();
									return x;
								}
								if (x.getMoney_spent() < 100000 && x.getDepth() < (int) Depth) {

									S.push(new NodeUpdated(x, "Build2"));
									S.push(new NodeUpdated(x, "Build1"));
									S.push(new NodeUpdated(x, "RequestEnergy"));
									S.push(new NodeUpdated(x, "RequestMaterials"));
									S.push(new NodeUpdated(x, "RequestFood"));

								}
							}
						}
						if (x.getDepth() == (int) Depth) {
							Final = false;
						}
					}
					break;
				case "Build2":
					if (check_validity(A, false)) {
						x = Build2(A);

						if (!VisitedNodes.contains(x)) {
							if (x.getWait() >= 1) {

								VisitedNodes.add(x);
								if (x.getProsperity() >= 100) {
									nodes_expanded = VisitedNodes.size();
									return x;
								}
								if (x.getMoney_spent() < 100000 && x.getDepth() < (int) Depth) {
									S.push(new NodeUpdated(x, "Wait"));
									S.push(new NodeUpdated(x, "Build2"));
									S.push(new NodeUpdated(x, "Build1"));

								}
							} else {

								VisitedNodes.add(x);
								if (x.getProsperity() >= 100) {
									nodes_expanded = VisitedNodes.size();
									return x;
								}
								if (x.getMoney_spent() < 100000 && x.getDepth() < (int) Depth) {

									S.push(new NodeUpdated(x, "Build2"));
									S.push(new NodeUpdated(x, "Build1"));
									S.push(new NodeUpdated(x, "RequestEnergy"));
									S.push(new NodeUpdated(x, "RequestMaterials"));
									S.push(new NodeUpdated(x, "RequestFood"));

								}
							}
						}
						if (x.getDepth() == (int) Depth) {
							Final = false;
						}
					}
					break;
				case "Wait":
					x = Wait(A);
					if (check_validity2(x)) {
						if (!VisitedNodes.contains(x)) {
							if (x.getWait() >= 1) {

								VisitedNodes.add(x);
								if (x.getMoney_spent() < 100000 && x.getDepth() < (int) Depth) {
									S.push(new NodeUpdated(x, "Wait"));
									S.push(new NodeUpdated(x, "Build2"));
									S.push(new NodeUpdated(x, "Build1"));

								}
							} else {

								VisitedNodes.add(x);
								if (x.getMoney_spent() < 100000 && x.getDepth() < (int) Depth) {

									S.push(new NodeUpdated(x, "Build2"));
									S.push(new NodeUpdated(x, "Build1"));
									S.push(new NodeUpdated(x, "RequestEnergy"));
									S.push(new NodeUpdated(x, "RequestMaterials"));
									S.push(new NodeUpdated(x, "RequestFood"));

								}
							}
							if (x.getDepth() == (int) Depth) {
								Final = false;
							}
						}
						break;

					}
				}
			}

		}

		return node;
	}

	// ******* Uniform Cost Search **********
	public static Node UC(Node node) {
		ArrayList<Node> UC = new ArrayList<Node>();
		Node Fail = node;
		HashSet<Node> VisitedNodes = new HashSet<Node>();
//		Queue q = new Queue(1000);
//		Node x;
		VisitedNodes.add(node);
		UC.add(RequestFood(node));
		UC.add(RequestMaterials(node));
		UC.add(RequestEnergy(node));
		
		if(check_validity(node,true)) {
			UC.add(Build1(node));
		}
		if(check_validity(node,false)) {
			UC.add(Build2(node));
			}
		
		
		UC = ReOrder(UC);

		while (!UC.isEmpty()) {
			Node A = UC.remove(0);
	//		System.out.println("Removing out : Money Spent"+A.getMoney_spent()+ " Wait Time "+ A.getWait() + " Food "+A.getFood()+" Materials "+A.getMaterials()+" Energy "+A.getEnergy()+" prosperity "+ A.getProsperity()+" "+ " Depth " + A.getDepth());
			   
			if (A.getProsperity() >= 100) {
				VisitedNodes.add(A);
				nodes_expanded = VisitedNodes.size();
				return A;
			}
			if (A.getMoney_spent() < 100000 && check_validity2(A)) {

				if (!VisitedNodes.contains(A)) {
					VisitedNodes.add(A);
					if (A.getWait() > 0) {
						if (check_validity(A, true)) {
	//						System.out.println("Inserting INN : Build1 process where waitTime " + A.getWait() + " Food "+A.getFood()+" Materials "+A.getMaterials()+" Energy "+A.getEnergy()+" prosperity "+ A.getProsperity()+" "+ " Depth " + A.getDepth());
							  
							UC.add(Build1(A));
						}
						if (check_validity(A, false)) {
	//						System.out.println("Inserting INN : Build2 process where waitTime " + A.getWait() + " Food "+A.getFood()+" Materials "+A.getMaterials()+" Energy "+A.getEnergy()+" prosperity "+ A.getProsperity()+" "+ " Depth " + A.getDepth());
							 
							UC.add(Build2(A));
						}
	//					System.out.println("Inserting INN :Wait process where waitTime " + A.getWait() + " Food "+A.getFood()+" Materials "+A.getMaterials()+" Energy "+A.getEnergy()+" prosperity "+ A.getProsperity()+" "+ " Depth " + A.getDepth());
						 
						UC.add(Wait(A));
						UC = ReOrder(UC);
					} else {
//						System.out.println("Inserting INN : Request Food process where waitTime " + A.getWait() + " Food "+A.getFood()+" Materials "+A.getMaterials()+" Energy "+A.getEnergy()+" prosperity "+ A.getProsperity()+" "+ " Depth " + A.getDepth());
//						if(A.getFood()<50)
//						{
						UC.add(RequestFood(A));
			//			}
//						System.out.println("Inserting INN : Request Materials process where waitTime " + A.getWait() + " Food "+A.getFood()+" Materials "+A.getMaterials()+" Energy "+A.getEnergy()+" prosperity "+ A.getProsperity()+" "+ " Depth " + A.getDepth());
//						if(A.getMaterials()<50)
//						{
						UC.add(RequestMaterials(A));
					//	}
	//					System.out.println("Inserting INN : Request Energy process where waitTime " + A.getWait() + " Food "+A.getFood()+" Materials "+A.getMaterials()+" Energy "+A.getEnergy()+" prosperity "+ A.getProsperity()+" "+ " Depth " + A.getDepth());
//						if(A.getEnergy()<50)
//						{
						UC.add(RequestEnergy(A));
					//	}
						if (check_validity(A, true)) {
//							System.out.println("Inserting INN : Build1 process where waitTime " + A.getWait() + " Food "+A.getFood()+" Materials "+A.getMaterials()+" Energy "+A.getEnergy()+" prosperity "+ A.getProsperity()+" "+ " Depth " + A.getDepth());
							  
							UC.add(Build1(A));
						}
						if (check_validity(A, false)) {
		//					System.out.println("Inserting INN : Build2 process where waitTime " + A.getWait() + " Food "+A.getFood()+" Materials "+A.getMaterials()+" Energy "+A.getEnergy()+" prosperity "+ A.getProsperity()+" "+ " Depth " + A.getDepth());
						 
							UC.add(Build2(A));
						}

						UC = ReOrder(UC);
					}

				}

			}
		}

		return Fail;

	}

	public static Node GR1(Node node) {

		ArrayList<Node> GR = new ArrayList<Node>();
		Node Fail = node;
		HashSet<Node> VisitedNodes = new HashSet<Node>();
		VisitedNodes.add(node);
		Queue q = new Queue(1000);
		Node x;
		GR.add(RequestFood(node));
		GR.add(RequestMaterials(node));
		GR.add(RequestEnergy(node));
		GR.add(Build1(node));
		GR.add(Build2(node));
		GR = heuristic_function1(GR);
		// GR=ReOrder(GR);

		while (!GR.isEmpty()) {
			Node A = GR.remove(0);

			if (A.getProsperity() >= 100) {
				VisitedNodes.add(A);
				nodes_expanded = VisitedNodes.size();
				return A;
			}
			if (A.getMoney_spent() < 100000 && check_validity2(A)) {

				if (!VisitedNodes.contains(A)) {
					VisitedNodes.add(A);
					if (A.getWait() > 0) {
						if (check_validity(A, true)) {
							GR.add(Build1(A));
						}
						if (check_validity(A, false)) {
							GR.add(Build2(A));
						}

						GR.add(Wait(A));

						GR = heuristic_function1(GR);
					} else {

						GR.add(RequestFood(A));
						GR.add(RequestMaterials(A));
						GR.add(RequestEnergy(A));

						if (check_validity(A, true)) {
							GR.add(Build1(A));
						}
						if (check_validity(A, false)) {
							GR.add(Build2(A));
						}

						GR = heuristic_function1(GR);
					}

				}

			}
		}

		return Fail;

	}

	public static Node GR2(Node node) {
		ArrayList<Node> GR = new ArrayList<Node>();
		Node Fail = node;
		HashSet<Node> VisitedNodes = new HashSet<Node>();
		VisitedNodes.add(node);
		GR.add(RequestFood(node));
		GR.add(RequestMaterials(node));
		GR.add(RequestEnergy(node));
		if (check_validity(node, true)) {
	  
			GR.add(Build1(node));
		}
		if (check_validity(node, false)) {
			GR.add(Build2(node));
		}
		
		
		GR = heuristic_function2(GR);
		// GR=ReOrder(GR);

		while (!GR.isEmpty()) {
			Node A = GR.remove(0);

			if (A.getProsperity() >= 100) {
				VisitedNodes.add(A);
				nodes_expanded = VisitedNodes.size();
				return A;
			}
			if (A.getMoney_spent() < 100000 && check_validity2(A)) {

				if (!VisitedNodes.contains(A)) {
					VisitedNodes.add(A);
					if (A.getWait() > 0) {
						if (check_validity(A, true)) {
							GR.add(Build1(A));
						}
						if (check_validity(A, false)) {
							GR.add(Build2(A));
						}

						GR.add(Wait(A));
						GR = heuristic_function2(GR);
					} else {

						GR.add(RequestFood(A));
						GR.add(RequestMaterials(A));
						GR.add(RequestEnergy(A));

						if (check_validity(A, true)) {
							GR.add(Build1(A));
						}
						if (check_validity(A, false)) {
							GR.add(Build2(A));
						}

						GR = heuristic_function2(GR);
					}

				}

			}
		}

		return Fail;

	}

	public static Node AS1(Node node) {
		ArrayList<Node> GR = new ArrayList<Node>();
		Node Fail = node;
		HashSet<Node> VisitedNodes = new HashSet<Node>();
		VisitedNodes.add(node);
		GR.add(RequestFood(node));
		GR.add(RequestMaterials(node));
		GR.add(RequestEnergy(node));
		GR.add(Build1(node));
		GR.add(Build2(node));
		GR = heuristic_functionA1(GR);
		// GR=ReOrder(GR);

		while (!GR.isEmpty()) {
			Node A = GR.remove(0);

			if (A.getProsperity() >= 100) {
				VisitedNodes.add(A);
				nodes_expanded = VisitedNodes.size();
				return A;
			}
			if (A.getMoney_spent() < 100000 && check_validity2(A)) {

				if (!VisitedNodes.contains(A)) {
					VisitedNodes.add(A);
					if (A.getWait() > 0) {
						if (check_validity(A, true)) {
							GR.add(Build1(A));
						}
						if (check_validity(A, false)) {
							GR.add(Build2(A));
						}

						GR.add(Wait(A));
						
						GR = heuristic_functionA1(GR);
					} else {

						GR.add(RequestFood(A));
						GR.add(RequestMaterials(A));
						GR.add(RequestEnergy(A));

						if (check_validity(A, true)) {
							GR.add(Build1(A));
						}
						if (check_validity(A, false)) {
							GR.add(Build2(A));
						}

						GR = heuristic_functionA1(GR);
					}

				}

			}
		}

		return Fail;
	}

	public static Node AS2(Node node) {
		ArrayList<Node> GR = new ArrayList<Node>();
		Node Fail = node;
		HashSet<Node> VisitedNodes = new HashSet<Node>();
		VisitedNodes.add(node);
		GR.add(RequestFood(node));
		GR.add(RequestMaterials(node));
		GR.add(RequestEnergy(node));
		GR.add(Build1(node));
		GR.add(Build2(node));
		GR = heuristic_functionA2(GR);
		// GR=ReOrder(GR);

		while (!GR.isEmpty()) {
			Node A = GR.remove(0);

			if (A.getProsperity() >= 100) {
				VisitedNodes.add(A);
				nodes_expanded = VisitedNodes.size();
				return A;
			}
			if (A.getMoney_spent() < 100000 && check_validity2(A)) {

				if (!VisitedNodes.contains(A)) {
					VisitedNodes.add(A);
					if (A.getWait() > 0) {
						if (check_validity(A, true)) {
							GR.add(Build1(A));
						}
						if (check_validity(A, false)) {
							GR.add(Build2(A));
						}

						GR.add(Wait(A));
						GR = heuristic_functionA2(GR);
					} else {

						GR.add(RequestFood(A));
						GR.add(RequestMaterials(A));
						GR.add(RequestEnergy(A));

						if (check_validity(A, true)) {
							GR.add(Build1(A));
						}
						if (check_validity(A, false)) {
							GR.add(Build2(A));
						}

						GR = heuristic_functionA2(GR);
					}

				}

			}
		}

		return Fail;
	}

	public static boolean isContainNode(ArrayList<Node> r, Node n) {

		for (int i = 0; i < r.size(); i++) {
			if (r.get(i).getEnergy() == n.getEnergy() && r.get(i).getFood() == n.getFood()
					&& r.get(i).getMaterials() == n.getMaterials() && r.get(i).getMoney_spent() == n.getMoney_spent()
					&& r.get(i).getProsperity() == n.getProsperity() && r.get(i).getWait() == n.getWait()
					&& r.get(i).isRequest_energy() == n.isRequest_energy()
					&& r.get(i).isRequest_food() == n.isRequest_food()
					&& r.get(i).isRequest_material() == n.isRequest_material()) {
				return true;

			}

		}

		return false;

	}

	public static String StringfyNode(Node n) {
		return n.getEnergy() + "/" + n.getFood() + "/" + n.getMaterials() + "/" + n.getMoney_spent() + "/"
				+ n.getProsperity() + "/" + n.getWait() + "/" + n.isRequest_energy() + "/" + n.isRequest_food() + "/"
				+ n.isRequest_material();
	}

//*****  we check Food,material,Energy >= 0 , before we build ,so not to put childern for this node ********** 
	public static boolean check_validity(Node n, boolean build1OR2) {
		if (build1OR2) // Build 1 --> true
		{
			if (((n.getFood() - getFoodUseBUILD1()) >= 0) && ((n.getEnergy() - getEnergyUseBUILD1()) >= 0)
					&& ((n.getMaterials() - getMaterialsUseBUILD1()) >= 0) && (n.getMoney_spent() + getPriceBUILD1() + (getFoodUseBUILD1() * getUnitPriceFood())
					+ (getEnergyUseBUILD1() * getUnitPriceEnergy()) + (getMaterialsUseBUILD1() * getUnitPriceMaterials())<=100000)
			) {
				return true;

			}
		} else if (!build1OR2) // Build 2 --> when build1OR2 is false
		{
			if (n.getFood() - getFoodUseBUILD2() >= 0 && n.getEnergy() - getEnergyUseBUILD2() >= 0
					&& n.getMaterials() - getMaterialsUseBUILD2() >= 0 && ((n.getMoney_spent() + getPriceBUILD2() + (getFoodUseBUILD2() * getUnitPriceFood())
							+ (getEnergyUseBUILD2() * getUnitPriceEnergy()) + (getMaterialsUseBUILD2() * getUnitPriceMaterials())<=100000)
					)) {
				return true;

			}

		}
		return false;

	}
//***** Food,material,Energy > 0 , after we request food or material or energy , wait ,so not to put childern for this node ********** 

	public static boolean check_validity2(Node n) {
		if (n.getFood() > 0 && n.getEnergy() > 0 && n.getMaterials() > 0) {
			return true;

		}
//	else if((n.getFood()>=0 && n.isRequest_food() && n.getWait()==0)||(n.getMaterials()>=0 && n.isRequest_material() && n.getWait()==0)||(n.getEnergy()>=0 && n.isRequest_energy() && n.getWait()==0))
//		
//	{
//		return true;
//		
//	}
		else {
			return false;
		}

	}

//***** Sort nodes in asscending order according to money spend of each node ********** 
	public static ArrayList<Node> ReOrder(ArrayList<Node> nodeList)

	{
//		for (int i = 0; i < nodeList.size(); i++) {
//			if (nodeList.get(i).getProsperity() == 100) {
//
//			}
//		}
		// Define a custom comparator based on money_spent attribute
		Comparator<Node> nodeComparator = Comparator.comparingInt(node -> node.getMoney_spent());

		// Sort the ArrayList using the custom comparator
		Collections.sort(nodeList, nodeComparator);
		return nodeList;

	}

	public static ArrayList<Node> heuristic_function1(ArrayList<Node> nodeList)

	{
		int price;
		double difference = 0;
		for (Node n : nodeList) {
			if (getProsperityBUILD1() > getProsperityBUILD2()) {
				difference = 100 - n.getProsperity();
				difference = Math.ceil(difference / getProsperityBUILD1());
				price = getPriceBUILD1();
				n.setHeuristic((int) difference * price);
			} else {
				difference = 100 - n.getProsperity();
				difference = Math.ceil(difference / getProsperityBUILD2());
				price = getPriceBUILD2();
				n.setHeuristic((int) difference * price);
			}
//		
		}
		// Define a custom comparator based on money_spent attribute
		Comparator<Node> nodeComparator = Comparator.comparingInt(node -> node.getHeuristic());

		// Sort the ArrayList using the custom comparator
		Collections.sort(nodeList, nodeComparator);
		return nodeList;

	}

	public static ArrayList<Node> heuristic_function2(ArrayList<Node> nodeList)

	{
		int price;
		double difference = 0;

		for (Node n : nodeList) {
			if (getProsperityBUILD1() > getProsperityBUILD2()) {
				difference = 100 - n.getProsperity();
				difference = Math.ceil(difference / getProsperityBUILD1());
				price = (int) (difference * getFoodUseBUILD1() - n.getFood()) * getUnitPriceFood()
						+ (int) (difference * getEnergyUseBUILD1() - n.getEnergy()) * getUnitPriceEnergy()
						+ (int) (difference * getMaterialsUseBUILD1() - n.getMaterials()) * getUnitPriceMaterials();
				n.setHeuristic(price);
			} else {
				difference = 100 - n.getProsperity();
				difference = Math.ceil(difference / getProsperityBUILD2());
				price = (int) (difference * getFoodUseBUILD2() - n.getFood()) * getUnitPriceFood()
						+ (int) (difference * getEnergyUseBUILD2() - n.getEnergy()) * getUnitPriceEnergy()
						+ (int) (difference * getMaterialsUseBUILD2() - n.getMaterials()) * getUnitPriceMaterials();
				n.setHeuristic(price);
			}
//		
		}
		// Define a custom comparator based on money_spent attribute
		Comparator<Node> nodeComparator = Comparator.comparingInt(node -> node.getHeuristic());

		// Sort the ArrayList using the custom comparator
		Collections.sort(nodeList, nodeComparator);
		return nodeList;

	}

	public static ArrayList<Node> heuristic_functionA1(ArrayList<Node> nodeList)

	{

		int price;
		double difference = 0;
		for (Node n : nodeList) {
			if (getProsperityBUILD1() > getProsperityBUILD2()) {
				difference = 100 - n.getProsperity();
				difference = Math.ceil(difference / getProsperityBUILD1());
				price = getPriceBUILD1() ;
				n.setHeuristic((int) difference * price + n.getMoney_spent());
			} else {
				difference = 100 - n.getProsperity();
				difference = Math.ceil(difference / getProsperityBUILD2());
				price = getPriceBUILD2() ;
				n.setHeuristic((int) difference * price + n.getMoney_spent());
			}
//		
		}
		// Define a a custom comparator based on money_spent attribute
		Comparator<Node> nodeComparator = Comparator.comparingInt(node -> node.getHeuristic());

		// Sort the ArrayList using the custom comparator
		Collections.sort(nodeList, nodeComparator);
		return nodeList;

	}

	public static ArrayList<Node> heuristic_functionA2(ArrayList<Node> nodeList)

	{
		int price;
		double difference = 0;

		for (Node n : nodeList) {
			if (getProsperityBUILD1() > getProsperityBUILD2()) {
				difference = 100 - n.getProsperity();
				difference = Math.ceil(difference / getProsperityBUILD1());
				price = (int) (difference * getFoodUseBUILD1() - n.getFood()) * getUnitPriceFood()
						+ (int) (difference * getEnergyUseBUILD1() - n.getEnergy()) * getUnitPriceEnergy()
						+ (int) (difference * getMaterialsUseBUILD1() - n.getMaterials()) * getUnitPriceMaterials();
				n.setHeuristic(price + n.getMoney_spent());
			} 
			else {
				difference = 100 - n.getProsperity();
				difference = Math.ceil(difference / getProsperityBUILD2());
				price = (int) (difference * getFoodUseBUILD2() - n.getFood()) * getUnitPriceFood()
						+ (int) (difference * getEnergyUseBUILD2() - n.getEnergy()) * getUnitPriceEnergy()
						+ (int) (difference * getMaterialsUseBUILD2() - n.getMaterials()) * getUnitPriceMaterials();
				n.setHeuristic(price + n.getMoney_spent());
			}
//	
		}

		// Define a custom comparator based on money_spent attribute
		Comparator<Node> nodeComparator = Comparator.comparingInt(node -> node.getHeuristic());

		// Sort the ArrayList using the custom comparator
		Collections.sort(nodeList, nodeComparator);
		//System.out.println();
		return nodeList;

	}

}