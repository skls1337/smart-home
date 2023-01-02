import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoorLockController {

  private Command doorLockCommand;

  @Autowired
  public DoorLockController(DoorLockCommand doorLockCommand) {
    this.doorLockCommand = doorLockCommand;
  }

  public void lockDoor() {
    doorLockCommand.execute();
  }

  public void unlockDoor() {
    doorLockCommand.execute();
  }

}