import java.util.Stack;

public class BallStack  {
    private Stack<newBall> _stack;
    public BallStack(){
        _stack=new Stack<newBall>();
    }
    public BallStack(int size,int x,int y){
        _stack=new Stack<newBall>();
        for (int i=0;i<size;i++) {
            _stack.push(new newBall(x,y));

        }

    }
    public void push(newBall n){
        _stack.push(n);
    }
    public newBall pop(){
        return _stack.pop();
    }
    public boolean isEmpty(){
        return _stack.isEmpty();
    }


}
