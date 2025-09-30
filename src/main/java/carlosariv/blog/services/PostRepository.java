package carlosariv.blog.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carlosariv.blog.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}