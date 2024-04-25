import java.util.HashSet;
import java.util.Set;                                                                       // Set permet de stocker des élements unique

public class Grid {
    private Set<Cell> actual_live_cells;                                                    // Stocke les cellules actuellement vivantes                                   
    private Set<Cell> futur_live_cells;                                                     // Stocke les futures celulles vivantes
    private Set<Cell> already_checked_cells;                                                // Stocke les cellules mortes déjà checkées pendant la création de la futur liste
    public Set<Integer> staying_alive_rules;                                                // Stocke les conditions pour qu'une cellules reste en vie
    public Set<Integer> born_rules;                                                         // Stocke les conditions pour qu'une cellules prenne vie

    public Grid() {
        this.actual_live_cells = new HashSet<>();
        this.futur_live_cells = new HashSet<>();
        this.already_checked_cells = new HashSet<>();

        this.staying_alive_rules = new HashSet<>(Set.of(2, 3));                         // Initialisation des conditions "staying_alive" 
        this.born_rules = new HashSet<>(Set.of(3));                                        // Initialisation des conditions "born" 
    }

    public boolean isCellAlive(Cell cell) {
        return this.actual_live_cells.contains(cell);
    }

    public boolean alreadyChecked(Cell cell) {
        return this.already_checked_cells.contains(cell);
    }

    public boolean isCellWillStayAlive(int liveNeighbors) {
        return this.staying_alive_rules.contains(liveNeighbors);
    }

    public boolean isCellWillBorn(int liveNeighbors) {
        return this.born_rules.contains(liveNeighbors);
    }

    public int countLiveNeighbors(Cell cell) {
        int count = 0;                                                                     
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;                                           // Ignorer la cellule elle-même (passe à l'itération suivante)
                Cell nearby_cell = new Cell(cell.getX() + dx, cell.getY()+ dy);             // Création de la cellule voisine
                if (isCellAlive(nearby_cell)) {                                             // Condition : la cellules voisine est vivante
                    count++;                                                                // Incrémentation du compteur de voisin
                }
            }
        }
        return count;
    }

    public void buildFuturGrid() {
        this.futur_live_cells.clear();                                                      // Vide la liste des futures cellules vivantes
        this.already_checked_cells.clear();

        for (Cell cell : this.actual_live_cells) {                                          // Boucle sur toutes les cellules actuellement vivantes

            // Vérifie quelles cellules reste en vie
            int liveNeighbors = countLiveNeighbors(cell);                                   // Calcul le nombre de voisin pour la cellule donnée
            if (isCellWillStayAlive(liveNeighbors)) {                                       // Condition : vérifie si la cellule respecte la condition "staying_alive"
                futur_live_cells.add(cell);                                                 // Ajoute la cellule à la liste des futures cellules vivantes
            }

            // Vérifie quelles cellules prennent vie
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {

                    if (dx == 0 && dy == 0) continue;                                       // Ignorer la cellule elle-même (passe à l'itération suivante)
                    Cell nearby_cell = new Cell(cell.getX() + dx, cell.getY()+ dy);         // Création de la cellule voisine
                    if(!alreadyChecked(cell)) continue;                                     // Ignorer la cellule si elle a déjà été verifié (passe à l'itération suivante)
                    liveNeighbors = countLiveNeighbors(nearby_cell);                        // Calcul le nombre de voisin pour la cellule donnée
                    if (!isCellAlive(nearby_cell) && isCellWillBorn(liveNeighbors)) {       // Condition : la cellule est morte et respecte la condition "born"
                        futur_live_cells.add(nearby_cell);                                  // Ajoute la cellule à la liste des futures cellules vivantes
                        already_checked_cells.add(nearby_cell);
                    }
                }
            }
        }        
    }

    public void switchGrid() {
        this.actual_live_cells = this.futur_live_cells;
    }
}
