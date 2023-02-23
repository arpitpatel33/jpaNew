package com.example.jpaNew.services;

import com.example.jpaNew.dto.PostDTO;
import com.example.jpaNew.entities.Comments;
import com.example.jpaNew.entities.SocialMediaPosts;
import com.example.jpaNew.repositories.SocialMediaPostsRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger ;
import java.util.List;
import java.util.Optional;


@Service
public class SocialMediaPostsService {

    @Autowired
    private SocialMediaPostsRepository socialMediaPostsRepository;

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private LikeService likeService;

    private static final Logger log= LoggerFactory.getLogger(SocialMediaPostsService.class);

    public List<SocialMediaPosts> getAll() {

        final String methodName = "getAll() : ";
        log.info(methodName + "called");

        List<SocialMediaPosts> all= socialMediaPostsRepository.findAll();
        return all;
    }

    public Optional<SocialMediaPosts> getById(Long id) {
        final String methodName= "getById() : ";
        log.info(methodName + "called");

        Optional<SocialMediaPosts> byId= socialMediaPostsRepository.findById(id);
        return byId;

    }

    public List<SocialMediaPosts> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId) {

        final String methodName = "getByIdGreaterThanEqualAndIdLessThanEqual() : ";
        log.info(methodName + "called");

        List<SocialMediaPosts> byId= socialMediaPostsRepository.findByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return byId;
    }

    public SocialMediaPosts save(SocialMediaPosts socialMediaPosts) {

        final String methodName= "save() : ";
        log.info(methodName + "called");

        SocialMediaPosts byId= socialMediaPostsRepository.save(socialMediaPosts);
        return byId;
    }

        public void deleteById(Long id) {

        final String methodName= "deleteById() : ";
        log.info(methodName + "called");

        socialMediaPostsRepository.deleteById(id);

    }

    public SocialMediaPosts findById(Long id) {

        final String methodName= "findById() : ";
        log.info(methodName + "called");

        SocialMediaPosts byId = socialMediaPostsRepository.findById(id).get();
        return byId;

    }


    public List<Comments> processPosts(SocialMediaPosts socialMediaPosts){
        final String methodName= "processPosts() : ";
        log.info(methodName + "called");

        if(socialMediaPosts == null){
            log.error(methodName + "Social media posts is null");
            return null;
        }
        long postsId = socialMediaPosts.getId();

        List<Comments> comments= commentsService.getByPostsId(socialMediaPosts.getId());

        return comments;
    }

    public PostDTO getByIdWithComment(Long postId){
        final String methodName = "getByIdWithComments() : ";
        log.info(methodName + "called  with " + postId);

        if(postId == null){
            log.error(methodName + "Post id is null");
            return null;
        }

        Optional<SocialMediaPosts> socialMediaPosts = getById(postId);
        if(socialMediaPosts.isEmpty()){
            log.error(methodName + "social media Posts id is null");
            return null;
        }

        List<Comments> comments = commentsService.getByPostsId(postId);

        PostDTO postDTO = new PostDTO();
        postDTO.setSocialMediaPosts(socialMediaPosts.get());
        postDTO.setComments(comments);


        return postDTO;
    }
}
