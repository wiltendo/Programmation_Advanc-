import matplotlib.pyplot as plt

def read_and_analyze(filename):
    """
    Lit un fichier texte au format spécifié et trace des graphiques.

    :param filename: Chemin vers le fichier texte.
    """
    # Initialiser les listes pour stocker les données
    pi_values = []
    num_points = []
    num_processors = []
    execution_times = []
    speedups = []

    # Lire le fichier et extraire les colonnes
    with open(filename, "r") as file:
        for line in file:
            # Séparer les colonnes par le délimiteur `;`
            try:
                pi, points, processors, time = map(float, line.strip().split(";"))
                pi_values.append(pi)
                num_points.append(points)
                num_processors.append(int(processors))
                execution_times.append(time)
            except ValueError:
                print(f"Erreur de format sur la ligne : {line.strip()}")

    # optimal_time = min(execution_times)  # Exemple: prendre le temps minimum des données comme référence
    single_process_time = execution_times[0]  # Le temps d'exécution avec un seul processeur
    for time in execution_times:
        speedup = single_process_time / time
        speedups.append(speedup)

    # Tracer le temps d'exécution en fonction des processeurs
    plt.plot(num_processors, execution_times, marker="x", color="red", label="Temps d'exécution")
    # plt.axhline(optimal_time, color="green", linestyle="--",
    #             label=f"Temps optimal: {optimal_time:.2f} s")  # Ajouter la ligne du temps optimal
    plt.title("Temps d'exécution vs Nombre de Processeurs")
    plt.xlabel("Nombre de Processeurs")
    plt.ylabel("Temps d'exécution (s)")
    plt.grid(True)
    plt.legend()

    plt.figure(figsize=(8, 6))
    plt.plot(num_processors, speedups, marker="o", color="red", label="Speedup")
    #plt.plot(num_processors, num_processors, color="b", label="Optimale") #Forte
    plt.axhline(y= speedups[0], color='b', linestyle='--',label="Optimale")#Faible

    plt.title("Speedup vs Nombre de Processeurs")
    plt.xlabel("Nombre de Processeurs")
    plt.ylabel("Speedup")
    plt.grid(True)
    plt.legend()

    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    # Spécifiez le fichier texte contenant les données
    filename = "C:/Users/willi/IdeaProjects/All/Pro_Dev/src/Mesure/output.txt"
    read_and_analyze(filename)