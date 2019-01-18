import React from "react";


const FAVOURITE_LABEL = "Mark as favourite";
const FAVOURITE_DISABLED_LABEL = "Favourited";

class Post extends React.Component {

    constructor(props) {
        super(props);

        this.markAsFavourite = this.markAsFavourite.bind(this);

        this.state = {
            isFavourited: false,
            buttonLabel: FAVOURITE_LABEL
        }
    }

    componentDidMount() {
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
    }

    componentWillUnmount() {
    }

    markAsFavourite() {
        var { isFavourited } = this.state;
        var { id } = this.props;

        // Hardcoding the endpoint. Ideally should be placed in a configuration to point to the service.
        // If using microservices with service lookup (DNS) hardcoding it wouldn't be all that bad.
        fetch('http://localhost:8080/post/'+id, {
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

            // Assuming HTTP Response code 200. Can also add a case for error scenarios.
            this.setState({
                isFavourited: !isFavourited,
                buttonLabel: FAVOURITE_DISABLED_LABEL
            });

            return data;
        });

    }

    render() {
        const { title, url } = this.props;
        const { isFavourited, buttonLabel } = this.state;

        return (
            <div className="post">
                <h3 className="post__title">{ title }</h3>
                <a className="post__link" href={ url } target="_blank">Read more</a>
                <button onClick={ (e) => this.markAsFavourite() } disabled={ isFavourited }> { buttonLabel }</button>
            </div>
        );
    }
}


export default Post;
