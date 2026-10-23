import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {

    @Test
    void testMemberCreation(){
       Member member = new Member("Jens Jensen", 1);

       assertEquals("Jens Jensen", member.name());
       assertEquals(1,member.id());
    }
}
