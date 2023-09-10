package com.ktxdevelopment.siratumustakim.post.service;

import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import com.ktxdevelopment.siratumustakim.post.model.response.PostLitResponse;
import com.ktxdevelopment.siratumustakim.post.model.response.PostResponse;
import com.ktxdevelopment.siratumustakim.post.repo.az.PostRepositoryAz;
import com.ktxdevelopment.siratumustakim.post.repo.tr.PostRepositoryTr;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

@ContextConfiguration(classes = {PostServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PostManagerServiceImplTest {
    @MockBean
    private PostRepositoryAz postRepositoryAz;

    @MockBean
    private PostRepositoryTr postRepositoryTr;

    @Autowired
    private PostServiceImpl postServiceImpl;

    /**
     * Method under test: {@link PostServiceImpl#getPostsPaginated(int, int, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPostsPaginated() {
        // TODO: Complete this test.
        //   Reason: R005 Unable to load class.
        //   Class: lombok.Lombok
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // TODO: Populate arranged inputs
        int page = 0;
        int limit = 0;
        String lang = "";

        // Act
        List<PostLitResponse> actualPostsPaginated = this.postServiceImpl.getPostsPaginated(page, limit, lang);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link PostServiceImpl#getTrendingPosts(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTrendingPosts() throws PostNotFoundException {
        // TODO: Complete this test.
        //   Reason: R005 Unable to load class.
        //   Class: lombok.Lombok
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        String lang = "";

        // Act
        List<PostLitResponse> actualTrendingPosts = this.postServiceImpl.getTrendingPosts(lang);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link PostServiceImpl#getFullPostById(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetFullPostById() {
        // TODO: Complete this test.
        //   Reason: R005 Unable to load class.
        //   Class: lombok.Lombok
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        String postId = "";
        String lang = "";

        // Act
        PostResponse actualFullPostById = this.postServiceImpl.getFullPostById(postId, lang);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link PostServiceImpl#getLitPostById(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetLitPostById() {
        // TODO: Complete this test.
        //   Reason: R005 Unable to load class.
        //   Class: lombok.Lombok
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        String postId = "";
        String lang = "";

        // Act
        PostLitResponse actualLitPostById = this.postServiceImpl.getLitPostById(postId, lang);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link PostServiceImpl#execLang(String)}
     */
    @Test
    void testExecLang() {
        assertSame(postServiceImpl.postRepositoryTr, postServiceImpl.execLang("Lang"));
        assertSame(postServiceImpl.postRepositoryAz, postServiceImpl.execLang("az"));
    }
}

