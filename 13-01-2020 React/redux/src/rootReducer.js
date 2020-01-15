import data from './api'

let data_send = data;
let chosen_send = [];

const rootReducer = (state, action) => {
    if (action.type === "CHANGE_DATA") {
        if (action.value != null) {
            data_send = data.filter((element) => {
                return ((element.station).toLowerCase()).includes(action.value);
            });
        }
    }
    if (action.type === "CHANGE_CHOSEN") {
        if (action.value != null)
            chosen_send = chosen_send.concat(action.value);
    }
    return {data: data_send, chosen: chosen_send};
};

export default rootReducer;