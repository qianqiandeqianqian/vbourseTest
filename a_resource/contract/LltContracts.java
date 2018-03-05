package com.hucheng.wallet.eth.contract;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.1.0.
 */
public class LltContracts extends Contract {
    private static final String BINARY = "60606040526000600660006101000a81548160ff0219169083151502179055506000600960006101000a81548160ff0219169083151502179055506305f5e100600c556200006b633b9aca00600c54620002fe64010000000002620025c3179091906401000000009004565b600d55620000976303938700600c54620002fe64010000000002620025c3179091906401000000009004565b600e55620000c2620f4240600c54620002fe64010000000002620025c3179091906401000000009004565b600f5560006011556040805190810160405280600a81526020017f3230313730383236303200000000000000000000000000000000000000000000815250601290805190602001906200011792919062000335565b506040805190810160405280600781526020017f4c4c546f6b656e00000000000000000000000000000000000000000000000000815250601390805190602001906200016592919062000335565b506040805190810160405280600381526020017f4c4c54000000000000000000000000000000000000000000000000000000000081525060149080519060200190620001b392919062000335565b506008601560006101000a81548160ff021916908360ff1602179055503415620001dc57600080fd5b60405160608062002ca5833981016040528080519060200190919080519060200190919080519060200190919050505b8282825b805b5b336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5082600d8190555081600a8190555042600b8190555081600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055505b5050505b505050620003e4565b600080828402905060008414806200032157508284828115156200031e57fe5b04145b15156200032a57fe5b8091505b5092915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200037857805160ff1916838001178555620003a9565b82800160010185558215620003a9579182015b82811115620003a85782518255916020019190600101906200038b565b5b509050620003b89190620003bc565b5090565b620003e191905b80821115620003dd576000816000905550600101620003c3565b5090565b90565b6128b180620003f46000396000f3006060604052361561017e576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806306fdde03146101835780630851762a14610212578063095ea7b31461027557806318160ddd146102cf57806323b872dd146102f857806329605e7714610371578063313ce567146103aa578063323661f6146103d957806334f96971146104025780633972323a1461042b5780634e71e0c81461049c57806355dfc97c146104b1578063570ca735146104da578063593557361461052f5780635a3b7e421461057c57806361dcd7ab1461060b57806367eeba0c146106345780636a28f0001461065d57806370a08231146106865780638da5cb5b146106d357806395d89b4114610728578063a9059cbb146107b7578063b20d30a914610811578063b813c62714610834578063dd62ed3e1461085d578063e30c3978146108c9578063e3bb34451461091e578063ec00d2a41461095e578063f25efc4914610987578063f2fde38b146109c5575b600080fd5b341561018e57600080fd5b6101966109fe565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156101d75780820151818401525b6020810190506101bb565b50505050905090810190601f1680156102045780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561021d57600080fd5b61025b600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091908035906020019091905050610a9c565b604051808215151515815260200191505060405180910390f35b341561028057600080fd5b6102b5600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091905050610ce8565b604051808215151515815260200191505060405180910390f35b34156102da57600080fd5b6102e2610e70565b6040518082815260200191505060405180910390f35b341561030357600080fd5b610357600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091905050610e76565b604051808215151515815260200191505060405180910390f35b341561037c57600080fd5b6103a8600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611127565b005b34156103b557600080fd5b6103bd611204565b604051808260ff1660ff16815260200191505060405180910390f35b34156103e457600080fd5b6103ec611217565b6040518082815260200191505060405180910390f35b341561040d57600080fd5b610415611287565b6040518082815260200191505060405180910390f35b341561043657600080fd5b61044c600480803590602001909190505061128d565b604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838152602001828152602001935050505060405180910390f35b34156104a757600080fd5b6104af6112d7565b005b34156104bc57600080fd5b6104c46113db565b6040518082815260200191505060405180910390f35b34156104e557600080fd5b6104ed6113e1565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561053a57600080fd5b610566600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611407565b6040518082815260200191505060405180910390f35b341561058757600080fd5b61058f6114ba565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156105d05780820151818401525b6020810190506105b4565b50505050905090810190601f1680156105fd5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561061657600080fd5b61061e611558565b6040518082815260200191505060405180910390f35b341561063f57600080fd5b61064761155e565b6040518082815260200191505060405180910390f35b341561066857600080fd5b610670611564565b6040518082815260200191505060405180910390f35b341561069157600080fd5b6106bd600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611637565b6040518082815260200191505060405180910390f35b34156106de57600080fd5b6106e6611681565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561073357600080fd5b61073b6116a6565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561077c5780820151818401525b602081019050610760565b50505050905090810190601f1680156107a95780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156107c257600080fd5b6107f7600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091905050611744565b604051808215151515815260200191505060405180910390f35b341561081c57600080fd5b61083260048080359060200190919050506118e0565b005b341561083f57600080fd5b610847611947565b6040518082815260200191505060405180910390f35b341561086857600080fd5b6108b3600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061194d565b6040518082815260200191505060405180910390f35b34156108d457600080fd5b6108dc6119d5565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561092957600080fd5b61094860048080359060200190919080359060200190919050506119fb565b6040518082815260200191505060405180910390f35b341561096957600080fd5b610971611c99565b6040518082815260200191505060405180910390f35b341561099257600080fd5b6109a86004808035906020019091905050611c9f565b604051808381526020018281526020019250505060405180910390f35b34156109d057600080fd5b6109fc600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611cc3565b005b60138054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610a945780601f10610a6957610100808354040283529160200191610a94565b820191906000526020600020905b815481529060010190602001808311610a7757829003601f168201915b505050505081565b6000600660009054906101000a900460ff16151515610aba57600080fd5b6001600660006101000a81548160ff0219169083151502179055504282111515610ae357600080fd5b42610afb6301e1338084611d6490919063ffffffff16565b101515610b0757600080fd5b610b5983600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611d6490919063ffffffff16565b600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055506060604051908101604052808573ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018381525060076000600854815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010155604082015181600201559050506008600081548092919060010191905055508373ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f8ff82a97675f0e72452c37c968c2c6121849f421aab8583cb6978f1e8263b3ff8585604051808381526020018281526020019250505060405180910390a3600190505b6000600660006101000a81548160ff0219169083151502179055505b9392505050565b600080821480610d7457506000600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054145b1515610d7f57600080fd5b81600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508273ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925846040518082815260200191505060405180910390a3600190505b92915050565b600d5481565b600080600560008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050610f4a83600460008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611d7e90919063ffffffff16565b600460008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550610fdf83600460008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611d6490919063ffffffff16565b600460008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055506110358382611d6490919063ffffffff16565b600560008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508373ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef856040518082815260200191505060405180910390a3600191505b509392505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561118257600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515156111be57600080fd5b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5b50565b601560009054906101000a900460ff1681565b600080600090505b60085481101561127f576007600082815260200190815260200160002060020154421015156112715760076000828152602001908152602001600020600101548201915061126c81611d9d565b61127a565b80806001019150505b61121f565b8191505b5090565b60085481565b60076020528060005260406000206000915090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060010154908060020154905083565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561133357600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5b565b600e5481565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60008060008091505b6008548210156114af576007600083815260200190815260200160002090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff1614156114a15761149e816001015484611d7e90919063ffffffff16565b92505b5b8180600101925050611410565b8292505b5050919050565b60128054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115505780601f1061152557610100808354040283529160200191611550565b820191906000526020600020905b81548152906001019060200180831161153357829003601f168201915b505050505081565b600b5481565b600f5481565b6000806000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156115c557600080fd5b60009150600090505b60115481101561162d57426010600083815260200190815260200160002060010154101561161f5760106000828152602001908152602001600020600001548201915061161a8161202a565b611628565b80806001019150505b6115ce565b8192505b5b505090565b6000600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205490505b919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60148054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561173c5780601f106117115761010080835404028352916020019161173c565b820191906000526020600020905b81548152906001019060200180831161171f57829003601f168201915b505050505081565b600061179882600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611d6490919063ffffffff16565b600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555061182d82600460008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611d7e90919063ffffffff16565b600460008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508273ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef846040518082815260200191505060405180910390a3600190505b92915050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561193b57600080fd5b80600f819055505b5b50565b600a5481565b6000600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205490505b92915050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611a5957600080fd5b600b548210158015611a6b5750428211155b1515611a7657600080fd5b611a7f8261223d565b151515611a8b57600080fd5b600f548311151515611a9c57600080fd5b611aa4612379565b6000600e54111515611ab557600080fd5b600e54831115611b3657600d54611ad9600e54600a54611d7e90919063ffffffff16565b1115611b0657600d54600a81905550611aff600a54600d54611d6490919063ffffffff16565b9250611b29565b611b1d600e54600a54611d7e90919063ffffffff16565b600a81905550600e5492505b6000600e81905550611bb3565b600d54611b4e84600a54611d7e90919063ffffffff16565b1115611b7b57600d54600a81905550611b74600a54600d54611d6490919063ffffffff16565b9250611b97565b611b9083600a54611d7e90919063ffffffff16565b600a819055505b611bac83600e54611d6490919063ffffffff16565b600e819055505b6040805190810160405280848152602001611bda62eff10085611d7e90919063ffffffff16565b81525060106000601154815260200190815260200160002060008201518160000155602082015181600101559050506011600081548092919060010191905055507f3f9e3494cddacfc8ffad423303d89b42edd68c349155fc54854d5d6dbe0a5e39338484604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838152602001828152602001935050505060405180910390a18290505b5b92915050565b60115481565b60106020528060005260406000206000915090508060000154908060010154905082565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611d1e57600080fd5b80600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5b50565b6000828211151515611d7257fe5b81830390505b92915050565b6000808284019050838110151515611d9257fe5b8091505b5092915050565b6000600760008381526020019081526020016000209050611e2e8160010154600460008460000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611d7e90919063ffffffff16565b600460008360000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f1f6c0a9bf76af8bc82d309c3041a10d100dafe019e5271d0e418fc57ffab3ab082600101548360020154604051808381526020018281526020019250505060405180910390a2600760006001600854038152602001908152602001600020600760008481526020019081526020016000206000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506001820154816001015560028201548160020155905050600760006001600854038152602001908152602001600020600080820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600182016000905560028201600090555050600860008154809291906001900391905055505b5050565b60006010600083815260200190815260200160002090506120b88160000154600460008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611d7e90919063ffffffff16565b600460008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055507fc34f1fead36337f1ed421262dd3660824fdc849a066c9ae4699ffcd1b6e0ba506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1682600001548360010154604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838152602001828152602001935050505060405180910390a160106000600160115403815260200190815260200160002060106000848152602001908152602001600020600082015481600001556001820154816001015590505060106000600160115403815260200190815260200160002060008082016000905560018201600090555050601160008154809291906001900391905055505b5050565b60008060008091506000601154111561236e57600090505b60115481101561236d5761227d61227862eff10086611d7e90919063ffffffff16565b61243b565b6000015161ffff166122a4601060008481526020019081526020016000206001015461243b565b6000015161ffff1614801561230157506122d26122cd62eff10086611d7e90919063ffffffff16565b61243b565b6020015160ff166122f8601060008481526020019081526020016000206001015461243b565b6020015160ff16145b8015612355575061232661232162eff10086611d7e90919063ffffffff16565b61243b565b6040015160ff1661234c601060008481526020019081526020016000206001015461243b565b6040015160ff16145b1561235f57600191505b5b8080600101915050612255565b5b8192505b5050919050565b426123936301e13380600b54611d7e90919063ffffffff16565b1080156123ad5750600960009054906101000a900460ff16155b156123ed576123cb6307270e00600c546125c390919063ffffffff16565b600e819055506001600960006101000a81548160ff0219169083151502179055505b426124076303c26700600b54611d7e90919063ffffffff16565b101561243857600d54600a54101561243757612430600a54600d54611d6490919063ffffffff16565b600e819055505b5b5b565b612443612831565b60008060008060009350612456866125f7565b856000019061ffff16908161ffff16815250506124786107b261ffff166126a3565b612489866000015161ffff166126a3565b039250826301e285000284019350826107b286600001510361ffff16036301e133800284019350600191505b600c8260ff1611151561250e576124d08286600001516126dd565b60ff16620151800290508584820111156124fb5781856020019060ff16908160ff168152505061250e565b80840193505b81806001019250506124b5565b600191505b612525856020015186600001516126dd565b60ff168260ff1611151561256d578584620151800111156125575781856040019060ff16908160ff168152505061256d565b62015180840193505b8180600101925050612513565b6000856060019060ff16908160ff16815250506000856080019060ff16908160ff168152505060008560a0019060ff16908160ff168152505060008560c0019060ff16908160ff16815250505b50505050919050565b600080828402905060008414806125e457508284828115156125e157fe5b04145b15156125ec57fe5b8091505b5092915050565b600080600080600092506301e133808581151561261057fe5b046107b261ffff1601915061262a6107b261ffff166126a3565b6126378361ffff166126a3565b039050806301e285000283019250806107b2830361ffff16036301e1338002830192505b848311156126975761266f600183036127b0565b15612682576301e285008303925061268c565b6301e13380830392505b60018203915061265b565b8193505b505050919050565b6000600182039150610190828115156126b857fe5b046064838115156126c557fe5b046004848115156126d257fe5b04030190505b919050565b600060018360ff1614806126f4575060038360ff16145b80612702575060058360ff16145b80612710575060078360ff16145b8061271e575060088360ff16145b8061272c5750600a8360ff16145b8061273a5750600c8360ff16145b1561274857601f90506127aa565b60048360ff16148061275d575060068360ff16145b8061276b575060098360ff16145b806127795750600b8360ff16145b1561278757601e90506127aa565b612790826127b0565b1561279e57601d90506127aa565b601c90506127aa565b5b5b5b92915050565b60008060048361ffff168115156127c357fe5b0661ffff161415156127d8576000905061282c565b600060648361ffff168115156127ea57fe5b0661ffff161415156127ff576001905061282c565b60006101908361ffff1681151561281257fe5b0661ffff16141515612827576000905061282c565b600190505b919050565b60e060405190810160405280600061ffff168152602001600060ff168152602001600060ff168152602001600060ff168152602001600060ff168152602001600060ff168152602001600060ff16815250905600a165627a7a723058206e78af9a981f3cde556ac0d854f5164f74a63e76e1814eb08c951aab8cd3711e0029000000000000000000000000000000000000000000000000016345785d8a0000000000000000000000000000000000000000000000000000006379da05b60000000000000000000000000000f60428d2a287ab7f136c26a9603e753387dca91f";

    protected LltContracts(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LltContracts(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<ReleaseSupplyEventResponse> getReleaseSupplyEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("ReleaseSupply", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ReleaseSupplyEventResponse> responses = new ArrayList<ReleaseSupplyEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ReleaseSupplyEventResponse typedResponse = new ReleaseSupplyEventResponse();
            typedResponse.log = transactionReceipt.getLogs().get(valueList.indexOf(eventValues));
            typedResponse.receiver = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.releaseTime = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ReleaseSupplyEventResponse> releaseSupplyEventObservable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        final Event event = new Event("ReleaseSupply", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ReleaseSupplyEventResponse>() {
            @Override
            public ReleaseSupplyEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ReleaseSupplyEventResponse typedResponse = new ReleaseSupplyEventResponse();
                typedResponse.log = log;
                typedResponse.receiver = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.releaseTime = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<UnfreezeAmountEventResponse> getUnfreezeAmountEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("UnfreezeAmount", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<UnfreezeAmountEventResponse> responses = new ArrayList<UnfreezeAmountEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            UnfreezeAmountEventResponse typedResponse = new UnfreezeAmountEventResponse();
            typedResponse.log = transactionReceipt.getLogs().get(valueList.indexOf(eventValues));
            typedResponse.receiver = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.unfreezeTime = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<UnfreezeAmountEventResponse> unfreezeAmountEventObservable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        final Event event = new Event("UnfreezeAmount", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, UnfreezeAmountEventResponse>() {
            @Override
            public UnfreezeAmountEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                UnfreezeAmountEventResponse typedResponse = new UnfreezeAmountEventResponse();
                typedResponse.log = log;
                typedResponse.receiver = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.unfreezeTime = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<TransferLockedTokenEventResponse> getTransferLockedTokenEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("TransferLockedToken", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<TransferLockedTokenEventResponse> responses = new ArrayList<TransferLockedTokenEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            TransferLockedTokenEventResponse typedResponse = new TransferLockedTokenEventResponse();
            typedResponse.log = transactionReceipt.getLogs().get(valueList.indexOf(eventValues));
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.releaseTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferLockedTokenEventResponse> transferLockedTokenEventObservable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        final Event event = new Event("TransferLockedToken", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferLockedTokenEventResponse>() {
            @Override
            public TransferLockedTokenEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                TransferLockedTokenEventResponse typedResponse = new TransferLockedTokenEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.releaseTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<ReleaseLockedBalanceEventResponse> getReleaseLockedBalanceEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("ReleaseLockedBalance", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ReleaseLockedBalanceEventResponse> responses = new ArrayList<ReleaseLockedBalanceEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ReleaseLockedBalanceEventResponse typedResponse = new ReleaseLockedBalanceEventResponse();
            typedResponse.log = transactionReceipt.getLogs().get(valueList.indexOf(eventValues));
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.releaseTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ReleaseLockedBalanceEventResponse> releaseLockedBalanceEventObservable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        final Event event = new Event("ReleaseLockedBalance", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ReleaseLockedBalanceEventResponse>() {
            @Override
            public ReleaseLockedBalanceEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ReleaseLockedBalanceEventResponse typedResponse = new ReleaseLockedBalanceEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.releaseTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Approval", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = transactionReceipt.getLogs().get(valueList.indexOf(eventValues));
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        final Event event = new Event("Approval", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = transactionReceipt.getLogs().get(valueList.indexOf(eventValues));
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<String> name() {
        Function function = new Function("name", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transferLockedToken(String _to, BigInteger _value,
            BigInteger _releaseTime) {
        Function function = new Function(
                "transferLockedToken", 
                Arrays.<Type>asList(new Address(_to),
                new Uint256(_value),
                new Uint256(_releaseTime)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> approve(String _spender, BigInteger _value) {
        Function function = new Function(
                "approve", 
                Arrays.<Type>asList(new Address(_spender),
                new Uint256(_value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> totalSupply() {
        Function function = new Function("totalSupply", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferFrom(String _from, String _to,
            BigInteger _value) {
        Function function = new Function(
                "transferFrom", 
                Arrays.<Type>asList(new Address(_from),
                new Address(_to),
                new Uint256(_value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOperator(String newOperator) {
        Function function = new Function(
                "transferOperator", 
                Arrays.<Type>asList(new Address(newOperator)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> decimals() {
        Function function = new Function("decimals", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> releaseLockedBalance() {
        Function function = new Function(
                "releaseLockedBalance", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> lockedBalanceCount() {
        Function function = new Function("lockedBalanceCount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple3<String, BigInteger, BigInteger>> lockedBalances(BigInteger param0) {
        final Function function = new Function("lockedBalances", 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<String, BigInteger, BigInteger>>(
                new Callable<Tuple3<String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple3<String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> claimOwnership() {
        Function function = new Function(
                "claimOwnership", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> limitSupplyPerYear() {
        Function function = new Function("limitSupplyPerYear", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> operator() {
        Function function = new Function("operator", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> lockedBalanceOf(String _owner) {
        Function function = new Function("lockedBalanceOf", 
                Arrays.<Type>asList(new Address(_owner)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> standard() {
        Function function = new Function("standard", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> createTime() {
        Function function = new Function("createTime", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> dailyLimit() {
        Function function = new Function("dailyLimit", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> unfreeze() {
        Function function = new Function(
                "unfreeze", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> balanceOf(String _owner) {
        Function function = new Function("balanceOf", 
                Arrays.<Type>asList(new Address(_owner)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> owner() {
        Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> symbol() {
        Function function = new Function("symbol", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transfer(String _to, BigInteger _value) {
        Function function = new Function(
                "transfer", 
                Arrays.<Type>asList(new Address(_to),
                new Uint256(_value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setDailyLimit(BigInteger _dailyLimit) {
        Function function = new Function(
                "setDailyLimit", 
                Arrays.<Type>asList(new Uint256(_dailyLimit)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> releasedSupply() {
        Function function = new Function("releasedSupply", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> allowance(String _owner, String _spender) {
        Function function = new Function("allowance", 
                Arrays.<Type>asList(new Address(_owner),
                new Address(_spender)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> pendingOwner() {
        Function function = new Function("pendingOwner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> releaseSupply(BigInteger releaseAmount,
            BigInteger timestamp) {
        Function function = new Function(
                "releaseSupply", 
                Arrays.<Type>asList(new Uint256(releaseAmount),
                new Uint256(timestamp)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> frozenRecordsCount() {
        Function function = new Function("frozenRecordsCount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple2<BigInteger, BigInteger>> frozenRecords(BigInteger param0) {
        final Function function = new Function("frozenRecords", 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<BigInteger, BigInteger>>(
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(new Address(newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<LltContracts> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, BigInteger initialSupply,
            BigInteger initReleasedSupply, String operator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint256(initialSupply),
                new Uint256(initReleasedSupply),
                new Address(operator)));
        return deployRemoteCall(LltContracts.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<LltContracts> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit,
            BigInteger initialSupply, BigInteger initReleasedSupply, String operator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint256(initialSupply),
                new Uint256(initReleasedSupply),
                new Address(operator)));
        return deployRemoteCall(LltContracts.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static LltContracts load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new LltContracts(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static LltContracts load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LltContracts(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class ReleaseSupplyEventResponse {
        public Log log;

        public String receiver;

        public BigInteger value;

        public BigInteger releaseTime;
    }

    public static class UnfreezeAmountEventResponse {
        public Log log;

        public String receiver;

        public BigInteger amount;

        public BigInteger unfreezeTime;
    }

    public static class TransferLockedTokenEventResponse {
        public Log log;

        public String from;

        public String to;

        public BigInteger value;

        public BigInteger releaseTime;
    }

    public static class ReleaseLockedBalanceEventResponse {
        public Log log;

        public String owner;

        public BigInteger value;

        public BigInteger releaseTime;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class TransferEventResponse {
        public Log log;

        public String from;

        public String to;

        public BigInteger value;
    }
}
