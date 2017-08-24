import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  private static final String ERROR = "WRONG PASSWORD";

  class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    public TrieNode() {
      children = new HashMap<Character, TrieNode>();
    }
    public TrieNode add(char c) {
      if ( !children.containsKey(c) ) {
        children.put(c,new TrieNode());
      }
      return children.get(c);
    }
    public void add(String s){
      if ( s == null || s.isEmpty() ) {
        return;
      }
      TrieNode next = this.add(s.charAt(0));
      if (s.length() == 1) {
        next.isWord = true;
      } else {
        next.add(s.substring(1));
      }
    }
    public Set<String> findIn(String s){
      Set<String> set = new HashSet<String>();
      findIn("", s, set);
      return set;
    }
    private void findIn(String before, String s, Set<String> set){
      if ( s == null ) return;
      if ( s.isEmpty() ) return;
      char c = s.charAt(0);
      if ( !children.containsKey(c) ) return;
      TrieNode next = children.get(c);
      before += c;
      if (next.isWord) {
        set.add(before);
      }
      next.findIn(before, s.substring(1), set);
    }
  }

  public static void main (String[] args) {
    new Solution().solve();
  }

  public void solve(){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    while ( n-- > 0 ) {
      TrieNode root = new TrieNode();
      int k = in.nextInt();
      while ( k-- > 0 ) {
        String current = in.next();
        root.add(current);
      }
      String password = in.next();
      System.out.println(isPossible(password, root));
    }
    in.close();
  }

  public String isPossible(String pass, TrieNode root) {
    return isPossible(pass, root, new HashMap<String, String>());
  }

  public String isPossible(String pass, TrieNode root, Map<String, String> cache) {
    if (cache.containsKey(pass)) {
      return cache.get(pass);
    }
    if (pass.isEmpty()) {
      return "";
    }
    Set<String> set = root.findIn(pass);
    for (String result: set) {
      String next = isPossible(pass.substring(result.length()), root, cache);
      if ( next.equals(ERROR) ) continue;
      result += " " + next;
      cache.put(pass, result);
      return result;
    }
    cache.put(pass, ERROR);
    return ERROR;
  }
}
