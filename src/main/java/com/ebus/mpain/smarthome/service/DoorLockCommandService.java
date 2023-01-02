import org.springframework.stereotype.Component;

@Component
public class DoorLockCommand implements Command {

  private DoorLock doorLock;
  private boolean lock;

  public DoorLockCommand(DoorLock doorLock, boolean lock) {
    this.doorLock = doorLock;
    this.lock = lock;
  }

  @Override
  public void execute() {
    if (lock) {
      doorLock.lock();
    } else {
      doorLock.unlock();
    }
  }

}