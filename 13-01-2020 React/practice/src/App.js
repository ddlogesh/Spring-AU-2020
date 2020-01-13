import React, {Component} from 'react';
import data from './api'
import Search from "./Search";

class App extends Component {
    constructor(props) {
        super(props);

        this.state = {
            data: data
        };

        this.modifyData = this.modifyData.bind(this);
    }

    modifyData(value) {
        this.setState({
            data: data.filter((element) => {
                return element.station.includes(value);
            })
        });
    }

    render() {
        return (
            <Search data={this.state.data} modifyData={this.modifyData}/>
        );
    }
}

export default App;