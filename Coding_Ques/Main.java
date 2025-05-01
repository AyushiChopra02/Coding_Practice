import java.util.*;
public class Main{
  public static void main(String[] args) {
ArrayList<Integer> v = new ArrayList<>(Arrays.asList(1,2,3));
PriorityQueue<Integer>pq= new PriorityQueue<>();
int ans=0;

for(int x : v)
pq.offer(x);

while(pq.size()>1){
  int e1= pq.poll();
  int e2=pq.poll();
  ans += e1+e2;
  System.out.println(e1+ " " +e2);
  pq.offer(e1+e2);

}
System.out.println(ans);

  }
}