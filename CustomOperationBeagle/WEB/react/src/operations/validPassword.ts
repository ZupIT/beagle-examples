
export function isValidPassword(value: string) {
    try {
      const rgx = new RegExp("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$")
      return rgx.test(value)
    } catch (e) {
      return false
    }
  }
