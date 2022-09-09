package as.florenko.hibernate;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response {
    public ResponseEntity<Object> notFoundResponse(String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", msg);
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> correctResponse(List<User> list) {
        Map<String, Object> map = new HashMap<>();
        map.put("Result", list);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
