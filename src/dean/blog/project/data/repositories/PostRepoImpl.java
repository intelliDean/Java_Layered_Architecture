//package dean.blog.project.data.repositories;
//
//import dean.blog.project.data.models.Post;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PostRepoImpl implements RepoOfPost{
//    private int idCounter;
//    private List<Post> postDb = new ArrayList<>();
//    @Override
//    public Post save(Post post) {
//        if (post.getId() != 0) {
//            update(post);
//        } else {
//        postDb.add(post);
//        post.setId(++idCounter);
//        }
//        return post;
//    }
//
//    private void update(Post post) {
//        Post post2 = findById(post.getId());
//        post2.setTitle(post.getTitle());
//        post2.setBody(post.getBody());
//    }
//
//    @Override
//    public Post findById(int id) {
//        for (Post post : postDb) {
//            if (post.getId() == id) {
//                return post;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Post> findAll() {
//        return postDb;
//    }
//
//    @Override
//    public long count() {
//        return postDb.size();
//    }
//
//    @Override
//    public void delete(Post post) {
//        postDb.removeIf(toDelete->toDelete.equals(post));
//    }
//
//    @Override
//    public void delete(int id) {
//        int index = getIndex(id);
//        if (index != -1) {
//            postDb.remove(index);
//        }
//    }
//
//    private int getIndex(int id) {
//        int index = -1;
//        for (int i = 0; i < postDb.size(); i++) {
//            if (postDb.get(i).getId() == id) {
//                index = i;
//            }
//        }
//        return index;
//    }
//
//    @Override
//    public void deleteAll() {
//        for (int i = 0; i < postDb.size(); i++) {
//            postDb.removeAll(findAll());
//        }
//    }
//}
