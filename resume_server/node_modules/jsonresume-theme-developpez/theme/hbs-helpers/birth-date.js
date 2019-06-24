const moment = require('moment');
const {SafeString} = require('handlebars');

const birthDate = (birth, gender) => {
    if(!gender) {
        gender = 'M';
    }
    const out = [];

    if (birth && Object.keys(birth).length) {
        if (birth.place) {
            out.push((gender === 'F') ? `<div> Née à ${birth.place}` : `<div> Né à ${birth.place}`);
        }
        if (birth.place && birth.state) {
            out.push(`, ${birth.state}`);
        }
        const year = birth.date ? moment(birth.date.toString(), ['YYYY-MM-DD']).format('YYYY') : '';
        if (year && birth.place && birth.state) {
            out.push(` en ${year}</div>`);
        } else if (year && (!birth.place || birth.state)) {
            out.push((gender === 'F') ? `<div> Née en ${year}</div>` : `<div> Né en ${year}</div>`);
        }
    }

    return new SafeString(out.join(''));
};

module.exports = {birthDate};
