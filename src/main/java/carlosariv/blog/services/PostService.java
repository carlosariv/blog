package carlosariv.blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import carlosariv.blog.models.Post;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> findFromId(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }
}