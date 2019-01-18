import React from 'react';
import Post from './post/Post.jsx';

class Posts extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      items: []
    }
  }

  componentDidMount() {

    fetch('http://localhost:8080/posts').
      then((response) => {
        return response.json();
      }).
      then((data) => {

        this.setState({
          items: data.items
        });
      });

  };

  componentDidUpdate(prevProps, prevState, snapshot) {
  }

  componentWillUnmount() {
  }

  renderItem(post, i) {
    const { id, score, title, url } = post;
    
    return (
        <Post title={ title }
              score={ score }
              id={ id }
              key={ id }
              url={ url }>

        </Post>
    );

  }

  renderList() {
    var { items } = this.state;

    if(items != undefined && items != 0) {
      return items.map(this.renderItem, this)
    }

    return (<span className="posts__emptylist">No posts to display. </span>);
    
  }

  render() {
    return (
        <div className="posts">
          { this.renderList() }
        </div>
    );
  }
}


export default Posts;
