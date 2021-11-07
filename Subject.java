import java.util.Observable;
import java.util.Observer;

public class Subject extends Observable implements Runnable {

    private int state;
    
    public Subject(int val) {
		this.setState(val);
	}

 public int getState() {
    return state;
 }

 public void setState(int state) {
    this.state = state;
    notifyAllObservers();
 }

 public void subscribe(Observer observer){
    this.addObserver(observer);
 }

public void unsubscribe(Observer observer){
	    this.deleteObserver(observer);		
 }
 
 public void notifyAllObservers(){
   this.notifyObservers();
 }
@Override
public void run() {
try {
		while (!Thread.currentThread().isInterrupted()) {
		this.setState((this.getState() + 1) % 60);
			Thread.sleep(2000);
		}
	} catch (InterruptedException e) {
	}
}


}
