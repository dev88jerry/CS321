

public class Main
{
    public static void main(String[] args) {
        
        Team teamA = new Team("Tigers");
        Team teamB = new Team();
        
        Player p = new Player();
        Player p1 = new Player("Name", 1);
        Player p2 = new Player("p2", 2);
        Player p3 = new Player("p3", 3);
        Player p4 = new Player("p4", 4);
        Player p5 = new Player("p5", 5);
        Player p6 = new Player("p6", 6);
        Player p7 = new Player("p7", 7);
        Player p8 = new Player("p8", 8);
        Player p9 = new Player("p9", 9);
        Player p10 = new Player("p10", 10);
        
        teamA.insert(p, 0);
        teamA.insert(p1, 1);
        teamA.insert(p2, 2);
        teamA.insert(p3, 3);
        teamA.insert(p4, 4);
        teamA.insert(p5, 5);
        teamA.insert(p6, 6);
        teamA.insert(p7, 7);
        teamA.insert(p8, 8);
        teamA.insert(p9, 9);
        teamA.insert(p10, 10);
        
        
    }
}




public class Player{
    
    private String playerName;
    private int position;
    
    public Player(){
        this.playerName = "";
        this.position = 0;
    }
    
    public Player(String name, int pos){
        this.playerName = name;
        this.position = pos;
    }
    
    
    public String getPlayerName(){
        return playerName;
    }
    
    public void setPlayerName(String name){
        this.playerName = name;
    }
    
    public int getPlayerPosition(){
        return position;
    }
    
    public void setPlayerPosition(int pos){
        this.position = pos;
    }
    
    @Override
    public boolean equals(Object o){
         if (o == this) {
            return true;
        }
        
        if (!(o instanceof Player)) {
            return false;
        }
        
        Player p = (Player) o;
        
        return this.playerName == p.getPlayerName() && this.position = p.getPlayerPosition();
        
    }
    
    @Override
    public String toString(){
        return "Player name: " + this.playerName + " position " + this.position;
    }
    
    
}





public class Team{
    
    private String teamName;
    private ArrayList<Players> roster = new ArrayList<Players>(9);
    
    public Team(){
        this.teamName = "";
    }
    
    public Team(String name){
        this.teamName = name;
    }
    
    public String getTeamName(){
        return teamName;
    }
    
    public void setTeamName(String team){
        this.teamName = team;
    }
    
    public boolean contains(Player p){
        Iterator<Player> iter = roster.iterator();
        
        while(iter.hasNext()){
            if(iter.getPlayerPosition() == p.getPlayerPosition() && iter.getPlayerName() == p.getPlayerName())
                return true;
        }
        
        return false;
    }
    
    public void insert(Player p, int pos){
        if(contains(p))
            makeError();
        else if(pos >= roster.size())
            makeError();
        else
            this.roster.set(pos, p);
    }
    
    public void makeError() throws Exception{
        throws new Exception("Error in player");
    }

} 
