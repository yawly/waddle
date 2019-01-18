import React from "react";


const REMOVE_LABEL = "Remove from favourites";
const ADD_LABEL = "Mark as favourite";


class Post extends React.Component {

    constructor(props) {
        super(props);

        this.toggleFavourite = this.toggleFavourite.bind(this);

        this.state = {
            isFavourite: false,
            buttonLabel: ADD_LABEL
        }
    }

    componentDidMount() {
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
    }

    componentWillUnmount() {
    }

    toggleFavourite() {
        var { isFavourite } = this.state;

        fetch('http://localhost:8080/post/'+this.props.id, {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(this.state)
        }).
        then((response) => {
            return response.json();
        }).
        then((data) => {

            this.setState({
                isFavourite: !isFavourite,
                buttonLabel: isFavourite ? REMOVE_LABEL : ADD_LABEL
            });

            return data;
        });

    }

    render() {
        const { title, url } = this.props;
        const { buttonLabel } = this.state;

        return (
            <div className="post">
                <h3 className="post__title">{ title }</h3>
                <a className="post__link" href={ url }>Read more</a>
                <button onClick={ (e) => this.toggleFavourite() }> { buttonLabel }</button>
            </div>
        );
    }
}


export default Post;
