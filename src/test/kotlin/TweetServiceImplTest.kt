import com.twittercasestudy.dao.TweetDao
import com.twittercasestudy.model.Tweet
import com.twittercasestudy.util.CurrentUserNameUtil
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.times

class TweetServiceImplTest {

    @Test
    fun testDeleteTweet(){
        val jdbcTweetDaoMock =  Mockito.mock(TweetDao :: class.java)
        //val currentUserNameMock = Mockito.mock(CurrentUserNameUtil :: class.java)
        CurrentUserNameUtil.setCurrentUserName("Param")
        val getCurrentUserNameUtil = CurrentUserNameUtil()
        //Mockito.`when`(currentUserNameMock.getCurrentUserName()).thenReturn("Param")
        //val tweetServiceImpl = TweetServiceImpl()
        //tweetServiceImpl.deleteTweet("#Diwali")
        jdbcTweetDaoMock.deleteTweet("#Diwali", getCurrentUserNameUtil.getCurrentUserName())
        Mockito.verify(jdbcTweetDaoMock, times(1)).deleteTweet("#Diwali", getCurrentUserNameUtil.getCurrentUserName())

    }

    @Test
    fun testDisplayTweet(){
        val jdbcTweetDaoMock =  Mockito.mock(TweetDao :: class.java)
        CurrentUserNameUtil.setCurrentUserName("Param")
        val getCurrentUserNameUtil = CurrentUserNameUtil()
        jdbcTweetDaoMock.displayTweet(getCurrentUserNameUtil.getCurrentUserName())
        Mockito.verify(jdbcTweetDaoMock, times(1)).displayTweet(getCurrentUserNameUtil.getCurrentUserName())
    }

    @Test
    fun testDisplayTweetByUserName(){
        val jdbcTweetDaoMock =  Mockito.mock(TweetDao :: class.java)
        jdbcTweetDaoMock.displayTweet("Piyush")
        Mockito.verify(jdbcTweetDaoMock, times(1)).displayTweet("Piyush")
    }

    @Test
    fun testUpdateTweet(){
        val jdbcTweetDaoMock =  Mockito.mock(TweetDao :: class.java)
        CurrentUserNameUtil.setCurrentUserName("Param")
        val getCurrentUserNameUtil = CurrentUserNameUtil()
        jdbcTweetDaoMock.updateTweet("Hi", "#Diwali", getCurrentUserNameUtil.getCurrentUserName())
        Mockito.verify(jdbcTweetDaoMock, times(1)).updateTweet("Hi", "#Diwali", getCurrentUserNameUtil.getCurrentUserName())
    }

    @Test
    fun testTrendingTweets(){
        val jdbcTweetDaoMock =  Mockito.mock(TweetDao :: class.java)
        jdbcTweetDaoMock.trendingTweets()
        jdbcTweetDaoMock.trendingTweets()
        Mockito.verify(jdbcTweetDaoMock, times(2)).trendingTweets()
    }

}