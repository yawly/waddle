package au.com.waddle.demo.repository;

import au.com.waddle.demo.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yawly on 17/1/19.
 */
public interface PostRepository extends CrudRepository<Post, Long> {

}
